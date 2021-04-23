package com.example.baselibrary.mvp.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baselibrary.mvp.presenter.IPresenter
import com.example.baselibrary.mvp.view.IView

/**
 *
 */
public abstract class BaseActivity<P : IPresenter?> : AppCompatActivity(),IView,IActivity, View.OnClickListener{

    protected var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(bindLayout())
        initData()
        initView()
    }

    override fun onClick(v: View) {}
    override fun showLoading() {}
    override fun hideLoading() {}

    override fun showToast(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter!=null){
            mPresenter!!.ondestroy()
        }
    }

}