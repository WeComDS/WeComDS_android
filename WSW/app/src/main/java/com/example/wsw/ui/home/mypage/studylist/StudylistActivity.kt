package com.example.wsw.ui.home.mypage.studylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import kotlinx.android.synthetic.main.activity_mypage.*

class StudylistActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_study_list)

        backBtn()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }
}