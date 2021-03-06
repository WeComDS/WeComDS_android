package com.example.wsw.ui.home.mypage.message

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import com.example.wsw.data.messagelist.MessageListData
import com.example.wsw.feature.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.activity_mypage.back
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        listitem_message.layoutManager = LinearLayoutManager(this)

        ApiServicempl.api.requestMessage().enqueue(object : Callback<List<MessageListData>> {
            override fun onResponse(call: Call<List<MessageListData>>, response: Response<List<MessageListData>>) {
                if(response.isSuccessful){
                    var mList = response.body()!!

                    runOnUiThread{
                        listitem_message.adapter = MessageAdapter(mList)
                    }
                }
            }

            override fun onFailure(call: Call<List<MessageListData>>, t: Throwable) {
                Log.e("Message Test", "OnFailure+${t.message}")
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