package com.example.wsw

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mypage.*

class RandomMessageViewActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_message_view)

        var btn_evaluation = findViewById<Button>(R.id.btn_evaluation)
        btn_evaluation.setOnClickListener {
            setDialog()
        }

        setRandomMessage()
        backBtn()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }

    private fun setRandomMessage(){
        var tv_message = findViewById<TextView>(R.id.tv_message)
        tv_message.text  = intent.getStringExtra("message")
    }

    private fun setDialog(){
        val dialog = RandomMessageDialogFragment()
        dialog.show(supportFragmentManager, "RandomMessageDialogFragment")
    }


}