package com.example.wsw.ui.home.mypage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.ui.home.mypage.message.MessageActivity
import com.example.wsw.ui.home.mypage.scrab.ScrabActivity
import com.example.wsw.ui.home.mypage.studylist.StudylistActivity
import kotlinx.android.synthetic.main.activity_mypage.*

class MypageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)



        backBtn()
        gotoAnotherPage()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }

    private fun gotoAnotherPage() {
        //스크랩
        gotoScrab?.setOnClickListener {
            val intent = Intent(this, ScrabActivity::class.java)
            startActivity(intent)
        }

        //쪽지함
        gotoMessage?.setOnClickListener {
            val intent2 = Intent(this, MessageActivity::class.java)
            startActivity(intent2)
        }

        //스터디지원현황
        gotoStudyList?.setOnClickListener {
            val intent3 = Intent(this, StudylistActivity::class.java)
            startActivity(intent3)
        }
    }

}