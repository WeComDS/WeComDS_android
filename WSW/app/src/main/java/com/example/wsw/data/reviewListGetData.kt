package com.example.wsw.data

data class reviewListGetData(
    var review_id:Int,
    var user_id:Int,
    var review_content:String,
    var review_date:String,
    var review_like:Int,
    var reviewe_CMcount:Int
)
