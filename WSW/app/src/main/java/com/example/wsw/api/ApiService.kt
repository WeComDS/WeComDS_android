package com.example.wsw.api

import com.example.wsw.data.SecretListGetData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("user/signup")
    fun requestRegister(@Field("user_name") user_name:String,
                        @Field("user_email")user_email:String,
                        @Field("user_pw") user_pw:String,
                        @Field("user_check") user_check:Int): Call<Boolean>

    //비밀게시판 전체호출
    @GET("/secret")
    fun secretList(): Call<ArrayList<SecretListGetData>>
}