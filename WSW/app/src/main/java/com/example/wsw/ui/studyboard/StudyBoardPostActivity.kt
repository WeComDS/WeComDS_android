package com.example.wsw.ui.studyboard

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R
import com.example.wsw.RandomMessageDialogFragment
import kotlinx.android.synthetic.main.activity_secret_board_post.*
import kotlinx.android.synthetic.main.activity_study_board_post.*

class StudyBoardPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_board_post)

        setPostText()
        val btn_apply = findViewById<Button>(R.id.btn_apply)
        btn_apply.setOnClickListener {
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
            backBtn()

        }
    }
    private fun setPostText(){
        tv_studyTitle.text = intent.getStringExtra("title")
        tv_studyPlace.text = intent.getStringExtra("style")
        tv_studyHeadCount.text = intent.getStringExtra("apply")+"/"+intent.getStringExtra("headcount")
        tv_studyState.text = intent.getStringExtra("state")
        tv_studyInfo.text = intent.getStringExtra("info")
        tv_studyNotice.text = intent.getStringExtra("notice")
    }
    private fun setDialog() {
        val dialog = ApplyDialogFragment()
        dialog.show(supportFragmentManager, "ApplyDialogFragment")
    }



    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }
}