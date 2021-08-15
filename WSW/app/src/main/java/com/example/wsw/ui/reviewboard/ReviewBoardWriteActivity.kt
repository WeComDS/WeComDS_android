package com.example.wsw.ui.reviewboard

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R

class ReviewBoardWriteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_board_write)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener{
            finish()
        }

        var btn_complete=findViewById<Button>(R.id.btn_complete)
        btn_complete.setOnClickListener {
            btn_complete.background= ContextCompat.getDrawable(this, R.drawable.round_complete_button_selected)
            btn_complete.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        }

    }
}