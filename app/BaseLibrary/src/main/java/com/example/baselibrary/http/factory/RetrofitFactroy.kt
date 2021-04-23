package com.example.baselibrary.http.factory

import com.example.baselibrary.http.product.IRetrofitProduct
import com.example.baselibrary.http.product.RetrofitHomeImpl
import com.example.baselibrary.http.product.RetrofitLoginImpl
import com.example.baselibrary.http.product.RetrofitRegisterImpl

/**
 *
 */
class RetrofitFactory : IRetrofitFactroy{

    companion object {
        @Volatile
        private var factroy: RetrofitFactory? = null

        @get:Synchronized
        val instance: RetrofitFactory?
            get() {
                if (factroy == null) {
                    factroy = RetrofitFactory()
                }
                return factroy
            }
    }

    private var retrofitHomeImpl: RetrofitHomeImpl? = null
    private var retrofitRegisterImpl: RetrofitRegisterImpl? = null
    private var retrofitLoginImpl: RetrofitLoginImpl? = null

    override fun create(type: RetrofitType): IRetrofitProduct? {
        return when(type){
            RetrofitType.HOME ->{
                if (retrofitHomeImpl==null){
                    retrofitHomeImpl=RetrofitHomeImpl()
                    //retrofitHomeImpl.create()
                }
                retrofitHomeImpl
            }
            RetrofitType.REGISTER ->{
                if (retrofitRegisterImpl==null){
                    retrofitRegisterImpl= RetrofitRegisterImpl()
                    //retrofitRegisterImpl.create()
                }
                retrofitRegisterImpl
            }
            RetrofitType.LOGIN ->{
                if (retrofitLoginImpl==null){
                    retrofitLoginImpl=RetrofitLoginImpl()
                    //retrofitHomeImpl.create()
                }
                retrofitLoginImpl
            }
        }
    }


}