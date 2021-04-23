package com.example.baselibrary.http.factory

import com.example.baselibrary.http.product.IRetrofitProduct

/**
 *
 */
interface IRetrofitFactroy {

    fun create(type : RetrofitType) : IRetrofitProduct?

}