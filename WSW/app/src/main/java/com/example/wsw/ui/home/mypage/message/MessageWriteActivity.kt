package com.example.wsw.ui.home.mypage.message

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.messagelist.MessageListData
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.activity_message_list.*
import kotlinx.android.synthetic.main.activity_message_write.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageWriteActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_write)

        messageSendFunction()
        backBtn()

    }

    private fun messageSendFunction() {
        //전송
        btn_send.setOnClickListener {
            //입력된 메시지가 있을 경우 전송
            if (et_message.text.isNotEmpty()) {
                sendMessage()
                finish()
            } else {
                Toast.makeText(this, "메시지를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendMessage(){
        ApiServicempl.api.writeMessage(1,"김덕성","유여대","2021-08-18 00:03:44","asdf")
                .enqueue(object : Callback<MessageListData> {
            override fun onResponse(call: Call<MessageListData>, response: Response<MessageListData>) {

            }

            override fun onFailure(call: Call<MessageListData>, t: Throwable) {
                Log.e("Message Test", "OnFailure+${t.message}")
            }
        })
    }

    /* X 화살표 클릭 리스너(뒤로가기) */
    fun backBtn(){
        exit.setOnClickListener {
            finish()
        }
    }
}