package com.example.wsw.ui.home.mypage.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.messagelist.MessageListData
import kotlinx.android.synthetic.main.activity_mypage.*
import retrofit2.Call
import retrofit2.Response

class MessageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        ApiServicempl.api.getMessage().enqueue(object :retrofit2.Callback<MessageListData> {
            override fun onResponse(call: Call<MessageListData>, response: Response<MessageListData>) {

            }

            override fun onFailure(call: Call<MessageListData>, t: Throwable) {

            }
        })

        backBtn()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }
}