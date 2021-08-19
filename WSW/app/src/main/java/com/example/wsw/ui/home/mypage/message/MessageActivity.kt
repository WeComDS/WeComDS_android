package com.example.wsw.ui.home.mypage.message

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.RandomMessageActivity
import com.example.wsw.RandomMessageViewActivity
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.messagelist.MessageListData
import kotlinx.android.synthetic.main.activity_mypage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageActivity : AppCompatActivity(){

    private val TAG = MessageActivity::class.qualifiedName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        ApiServicempl.api.requestMessage().enqueue(object : Callback<MessageListData> {
            override fun onResponse(call: Call<MessageListData>, response: Response<MessageListData>) {
                if (response.isSuccessful){

                }
            }

            override fun onFailure(call: Call<MessageListData>, t: Throwable) {
                TODO("Not yet implemented")
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