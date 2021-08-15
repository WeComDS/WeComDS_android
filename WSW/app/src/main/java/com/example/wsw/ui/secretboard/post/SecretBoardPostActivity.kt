package com.example.wsw.ui.secretboard.post

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.feature.signup.SignupActivity

class SecretBoardPostActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_board_post)

        var btn_recommend = findViewById<ImageView>(R.id.btn_recommend)
        btn_recommend.setOnClickListener{
            btn_recommend.setImageResource(R.drawable.ic_recommend_white)
            btn_recommend.setBackgroundResource(R.drawable.round_recommend_scrap_selected)
        }

    }
}