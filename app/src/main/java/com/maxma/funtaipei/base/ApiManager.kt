package com.maxma.funtaipei.base

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    val API_DOMAIN = "https://www.travel.taipei/open-api/"
    var service: APIService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(APIService::class.java)
    }
}