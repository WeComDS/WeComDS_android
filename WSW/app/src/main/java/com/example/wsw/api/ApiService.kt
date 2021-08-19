package com.example.wsw.api


import com.example.wsw.data.*
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
    @FormUrlEncoded
    @POST("random/send")
    fun sendRandomMessage(@Field("user_id") user_id: Int,
                          @Field("rand_content") rand_content: String): Call<Boolean>

    @POST("random/get")
    fun requestRandomMessage(): Call<String>

    @POST("random/dislike")
    fun sendDislike(): Call<Boolean>

    //비밀게시판
    @GET("/secret")
    fun secretList(): Call<ArrayList<SecretListGetData>>

    @FormUrlEncoded
    @POST("secret/write")
    fun secretPost(@Field("user_id") user_id: Int,
                   @Field("sec_content") sec_content:String,
                   @Field("sec_date") sec_date:String,
                   @Field("sec_CMcount") sec_CMcount:Int,
                   @Field("sec_like") sec_like:Int): Call<Boolean>

    @DELETE("secret/delete/{id}")
    fun deleteSecretPost(@Path("id") id: Int): Call<Void>

    //질문게시판
    @GET("/question")
    fun questionList():Call<ArrayList<questionListGetData>>

    //리뷰게시판
    @GET("/review")
    fun reviewList():Call<ArrayList<reviewListGetData>>

    //스터디게시판 전체호출
    @GET("/study")
    fun studyList(): Call<ArrayList<StudyListGetData>>

    @FormUrlEncoded
    @POST("/study/write")
    fun studyWrite(@Field("user_id") user_id: Int,
                   @Field("study_title") study_title: String,
                   @Field("study_date") study_date: String,
                   @Field("study_style") study_style: String,
                   @Field("study_headcount") study_headcount: Int,
                   @Field("study_introduce") study_introduce: String,
                   @Field("study_notice") study_notice: String,
                   @Field("study_state") study_state: String,
                   @Field("study_applycount") study_applycount: Int): Call<Boolean>
}