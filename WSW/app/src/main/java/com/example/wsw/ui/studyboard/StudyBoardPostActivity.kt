package com.example.wsw.ui.studyboard

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R
import com.example.wsw.RandomMessageDialogFragment
import kotlinx.android.synthetic.main.activity_study_board_post.*

class StudyBoardPostActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_board_post)

        val btn_apply = findViewById<Button>(R.id.btn_apply)
        btn_apply.setOnClickListener{
            setDialog()
        }

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

    private fun setDialog(){
        val dialog = ApplyDialogFragment()
        dialog.show(supportFragmentManager, "ApplyDialogFragment")
    }
}