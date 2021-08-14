package com.example.wsw.ui.secretboard.post

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R

class SecretBoardWriteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_board_write)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener{
            finish()
        }

    }
}