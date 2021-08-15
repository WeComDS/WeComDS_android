package com.example.wsw.ui.reviewboard

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R

class ReviewBoardPostActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_board_post)

        var btn_recommend=findViewById<ImageView>(R.id.btn_recommend)

        btn_recommend.setOnClickListener{
            btn_recommend.setImageResource(R.drawable.ic_recommend_white)
            btn_recommend.background= ContextCompat.getDrawable(this, R.drawable.round_recommend_scrap_selected)
        }
        var btn_scrap=findViewById<ImageView>(R.id.btn_scrap)
        btn_scrap.setOnClickListener{
            btn_scrap.setImageResource(R.drawable.ic_scrap_white)
            btn_scrap.background= ContextCompat.getDrawable(this, R.drawable.round_recommend_scrap_selected)
        }
    }
}