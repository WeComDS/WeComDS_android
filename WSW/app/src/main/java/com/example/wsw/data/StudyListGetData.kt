package com.example.wsw.data

data class StudyListGetData(
        var study_id:Int,
        var user_id:Int,
        var study_title:String,
        var study_date:String,
        var study_style:String,
        var study_headcount:Int,
        var study_introduce:String,
        var study_notice:String,
        var study_state:String,
        var study_applycount:Int
)
