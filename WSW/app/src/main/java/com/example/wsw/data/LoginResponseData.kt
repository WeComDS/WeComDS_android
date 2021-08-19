package com.example.wsw.data

import com.google.gson.annotations.SerializedName

data class LoginResponseData(

        @SerializedName("userId")
        val user_id: Int,

        @SerializedName("userName")
        val user_name: String,

        @SerializedName("userEmail")
        val user_email: String
)
