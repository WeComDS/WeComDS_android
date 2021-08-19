package com.example.wsw.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServicempl {
    // 하나씩 본인 url 쓰기 :)
    private const val BASE_SERVER_URL = "http://192.168.0.21:3000"
    //private const val BASE_SERVER_URL = "http://172.30.1.38:3000"
    //private const val BASE_SERVER_URL = "http://192.168.0.21:3000"
    //private const val BASE_SERVER_URL = "http://192.168.0.21:3000"


    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    var api = retrofit.create(ApiService::class.java)
}