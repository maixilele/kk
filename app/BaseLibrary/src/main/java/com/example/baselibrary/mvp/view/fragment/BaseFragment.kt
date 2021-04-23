package com.example.baselibrary.mvp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.baselibrary.mvp.presenter.IPresenter
import com.example.baselibrary.mvp.view.IView

/**
 *
 */
public abstract class BaseFragment<P : IPresenter?> : Fragment(),IView,IFragment{

    protected var mPresenter : P? =null
    private var mBaseView : View?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBaseView=inflater.inflate(bindLayout(),container,false)
        return mBaseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun showLoading() {}
    override fun hideLoading() {}

    override fun showToast(msg: String?) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
    }

    override fun <T : View?> findViewById(id: Int): T {
        return mBaseView!!.findViewById<T>(id)
    }

}