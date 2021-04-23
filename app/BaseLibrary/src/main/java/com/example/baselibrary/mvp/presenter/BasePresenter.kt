package com.example.baselibrary.mvp.presenter

import com.example.baselibrary.mvp.model.IModel
import com.example.baselibrary.mvp.view.IView

/**
 *
 */
class BasePresenter<M : IModel?, V : IView?>(mModel: M, mView: V) : IPresenter {
    protected var mModel: M?
    protected var mView: V
    override fun ondestroy() {
        if (mModel != null) {
            mModel!!.ondestroy()
            mModel = null
        }
        Runtime.getRuntime().gc()
    }

    init {
        this.mModel = mModel
        this.mView = mView
    }
}