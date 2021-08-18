package com.example.wsw.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    //쪽지 첫화면 데이터 가져오기(쪽지 목록 조회)
    @GET("/message/readAll")
    @Headers("accept: application/json", "content-type: application/json")
    fun get_message(): Call<HTTP_GET_Model>

    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http://localhost:3000" // 주소

        fun create(): ApiService {


            val gson : Gson =   GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiService::class.java)
        }
    }
}