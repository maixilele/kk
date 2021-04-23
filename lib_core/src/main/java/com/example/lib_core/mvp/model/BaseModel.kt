package com.example.baselibrary.mvp.model

import com.example.baselibrary.http.call.CallObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.HashSet

/**
 *
 */
public open class BaseModel<T> : IModel{

    private var callObserverSet : MutableSet<CallObserver<T>>? = null

    fun doRequest(observable: Observable<T>,callObserver: CallObserver<T>){
        if (callObserver==null){
            callObserverSet=HashSet<CallObserver<T>>()
        }
        callObserverSet?.add(callObserver)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callObserver)
    }

    override fun ondestroy() {
        for (callObserver in callObserverSet!!){
            if ((callObserver as DisposableObserver<*>).isDisposed){
                callObserver.dispose()
            }
        }
        callObserverSet!!.clear()
        callObserverSet=null
    }

}

