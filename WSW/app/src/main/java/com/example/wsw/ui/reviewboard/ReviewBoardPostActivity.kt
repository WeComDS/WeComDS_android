package com.example.wsw.ui.reviewboard

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R

class ReviewBoardPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_board_post)

        var Three_dots = findViewById<ImageView>(R.id.review_Three_dots)

        Three_dots.setOnClickListener {
            var pop = PopupMenu(applicationContext, it)

            menuInflater.inflate(R.menu.menu_study_recruitment, pop.menu)
            pop.show()
            pop.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu1 -> {
                        Log.d("MainActivity", "눌리는중1")
                        return@setOnMenuItemClickListener true
                    }
                    R.id.menu2 -> {
                        Log.d("MainActivity", "눌리는중2")
                        return@setOnMenuItemClickListener true
                    }
                    else -> {
                        return@setOnMenuItemClickListener false
                    }

                }
            }

            var btn_recommend = findViewById<ImageView>(R.id.btn_recommend)

            btn_recommend.setOnClickListener {
                btn_recommend.setImageResource(R.drawable.ic_recommend_white)
                btn_recommend.background =
                    ContextCompat.getDrawable(this, R.drawable.round_recommend_scrap_selected)
            }
            var btn_scrap = findViewById<ImageView>(R.id.btn_scrap)
            btn_scrap.setOnClickListener {
                btn_scrap.setImageResource(R.drawable.ic_scrap_white)
                btn_scrap.background =
                    ContextCompat.getDrawable(this, R.drawable.round_recommend_scrap_selected)

            }
        }
    }
}