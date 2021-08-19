package com.example.wsw.api

import com.example.wsw.data.messagelist.MessageListData
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    /* 로그인/회원가입 */
    @FormUrlEncoded
    @POST("user/signup")
    fun requestRegister(@Field("user_name") user_name:String,
                        @Field("user_email")user_email:String,
                        @Field("user_pw") user_pw:String,
                        @Field("user_check") user_check:Int): Call<Boolean>

    @FormUrlEncoded
    @POST("message/readAll")
    fun requestMessage(): Call<MessageListData>

    @POST("random/get")
    fun requestRandomMessage(): Call<String>

    @POST("random/dislike")
    fun sendDislike(): Call<Boolean>

}