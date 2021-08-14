package com.example.wsw.ui.studyboard

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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
    }

    private fun setDialog(){
        val dialog = ApplyDialogFragment()
        dialog.show(supportFragmentManager, "ApplyDialogFragment")
    }
}