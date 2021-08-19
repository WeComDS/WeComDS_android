package com.example.wsw.api


import com.example.wsw.data.LoginResponseData
import com.example.wsw.data.messagelist.MessageListData
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    /* 로그인/회원가입 */
    @FormUrlEncoded
    @POST("user/login")
    fun requestLogin(@Field("user_email") user_email: String,
                     @Field("user_pw") user_pw: String): Call<LoginResponseData>

    @FormUrlEncoded
    @POST("user/signup")
    fun requestRegister(@Field("user_name") user_name: String,
                        @Field("user_email") user_email: String,
                        @Field("user_pw") user_pw: String,
                        @Field("user_check") user_check: Int): Call<Boolean>


    @GET("message/readAll")
    fun requestMessage(): Call<List<MessageListData>>

    @GET("message/get")
    fun showMessage(): Call<List<MessageListData>>

    @FormUrlEncoded
    @PUT("message/write")
    fun writeMessage(@Field("user_id")user_id: Int,
                     @Field("mes_sendID")mes_sendID: String,
                     @Field("mes_receiveID")mes_receiveID: String,
                     @Field("mes_date")mes_date: String,
                     @Field("mes_content")mes_content: String): Call<MessageListData>

    /* 랜덤 메세지 */
    @POST("random/get")
    fun requestRandomMessage(): Call<String>

    @POST("random/dislike")
    fun sendDislike(): Call<Boolean>

}