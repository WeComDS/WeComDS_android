package com.example.wsw.data.messagelist

import com.google.gson.annotations.SerializedName
import java.sql.Date

data class MessageListData(
        val user_id: Int,
        var mes_sendID : String,
        var mes_receiveID : String,
        var mes_content: String,
        var mes_date: String
)
