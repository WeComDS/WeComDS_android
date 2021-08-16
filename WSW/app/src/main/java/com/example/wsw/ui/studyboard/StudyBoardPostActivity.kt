package com.example.wsw.ui.studyboard

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
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

        var Three_dots = findViewById<ImageView>(R.id.study_three_dots)

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
        }
    }

    private fun setDialog(){
        val dialog = ApplyDialogFragment()
        dialog.show(supportFragmentManager, "ApplyDialogFragment")
    }
}