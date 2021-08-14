package com.example.wsw.ui.studyboard

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R

class StudyBoardWriteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_board_write)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener{
            finish()
        }
    }
}