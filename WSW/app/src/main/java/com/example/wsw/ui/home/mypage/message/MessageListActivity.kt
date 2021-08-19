package com.example.wsw.ui.home.mypage.message

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import com.example.wsw.data.messagelist.MessageListData
import com.example.wsw.feature.signup.SignupActivity
import com.example.wsw.ui.studyboard.StudyBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.activity_message.listitem_message
import kotlinx.android.synthetic.main.activity_message_list.*
import kotlinx.android.synthetic.main.activity_mypage.*
import kotlinx.android.synthetic.main.activity_mypage.back
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageListActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)

        listitem_message_all.layoutManager = LinearLayoutManager(this)

        ApiServicempl.api.showMessage().enqueue(object : Callback<List<MessageListData>> {
            override fun onResponse(call: Call<List<MessageListData>>, response: Response<List<MessageListData>>) {
                if(response.isSuccessful){
                    var mList = response.body()!!

                    runOnUiThread{
                        listitem_message_all.adapter = MessageListAdapter(mList)
                    }

                }
            }

            override fun onFailure(call: Call<List<MessageListData>>, t: Throwable) {
                Log.e("Message Test", "OnFailure+${t.message}")
            }
        })

        fab_write.setOnClickListener {
            var intent = Intent(applicationContext, MessageWriteActivity::class.java)
            startActivity(intent)
        }

        backBtn()

    }

    /* 뒤로가기 화살표 클릭 리스너 */
    fun backBtn(){
        back.setOnClickListener {
            finish()
        }
    }
}