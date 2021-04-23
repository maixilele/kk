package com.example.baselibrary.http.call

/**
 *
 */
interface IObserver<T>{

    fun success(bean : T)

    fun fail(errMsg : String)

}