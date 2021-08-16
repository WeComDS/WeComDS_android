package com.example.wsw.ui.home.mypage.scrab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import kotlinx.android.synthetic.main.activity_mypage.*

class ScrabActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrab)

        backBtn()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }
}