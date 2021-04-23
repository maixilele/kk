package com.example.baselibrary.http.product

import retrofit2.Retrofit

/**
 *
 */
interface IRetrofitProduct {

    fun create() : IRetrofitProduct?

    fun getRetrofit() : Retrofit?

}