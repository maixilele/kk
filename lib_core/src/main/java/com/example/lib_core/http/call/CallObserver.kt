package com.example.baselibrary.http.call

import com.blankj.utilcode.util.ToastUtils
import io.reactivex.observers.DisposableObserver

/**
 *
 */
abstract class CallObserver<T> : DisposableObserver<T>(),IObserver<T>{

    override fun onComplete() {}

    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
        fail("网络异常")
    }

    override fun fail(errMsg: String) {
        ToastUtils.showShort(errMsg);
    }
}