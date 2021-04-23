package com.example.baselibrary.http.product

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 */
class RetrofitHomeImpl : IRetrofitProduct{

    private var mRetrofit : Retrofit? = null

    override fun create(): IRetrofitProduct? {
        mRetrofit=Retrofit.Builder()
            .baseUrl("")
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return this
    }

    override fun getRetrofit(): Retrofit?{
        if (mRetrofit==null){
            create()
        }
        return mRetrofit
    }


}