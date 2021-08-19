package com.example.wsw.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    /* 로그인/회원가입 */
    @FormUrlEncoded
    @POST("user/signup")
    fun requestRegister(@Field("user_name") user_name:String,
                        @Field("user_email")user_email:String,
                        @Field("user_pw") user_pw:String,
                        @Field("user_check") user_check:Int): Call<Boolean>

    @POST("random/get")
    fun requestRandomMessage(): Call<String>


    @POST("random/dislike")
    fun sendDislike(): Call<Boolean>

}