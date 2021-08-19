package com.example.wsw.ui.home.mypage.message

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.MainActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.messagelist.MessageListData
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.ChronoUnit
import kotlinx.android.synthetic.main.activity_message_write.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageWriteActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_write)

        AndroidThreeTen.init(this)

        var current = org.threeten.bp.LocalDateTime.now()
        val formatter = DateTimeFormatter.ISO_DATE_TIME

        var user_id = 1
        var mes_sendID = "김덕성"
        var mes_receiveID = "유여대"
        var mes_date = current.format(formatter).toString()
        var mes_content = findViewById<EditText>(R.id.et_message)


        var btn_send = findViewById<Button>(R.id.btn_send)
        btn_send.setOnClickListener {

            ApiServicempl.api.writeMessage(
                    user_id,
                    mes_sendID,
                    mes_receiveID,
                    mes_date,
                    mes_content.text.toString()
            )
                    .enqueue(object : retrofit2.Callback<Boolean> {
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if(response.body() == true && et_message.text.isNotEmpty()){
                                Log.d("onResponse", "성공")
                                var intent = Intent(applicationContext, MessageListActivity::class.java)
                                startActivity(intent)
                            }else{
                                Log.d("onResponse", "실패")
                            }
                        }
                        override fun onFailure(call: Call<Boolean>, t: Throwable) {
                            Log.d("onResponse",t.message.toString())
                            var intent = Intent(applicationContext, MessageListActivity::class.java)
                            startActivity(intent)
                        }

                    }

                    )
        }
        backBtn()

    }

    /* X 화살표 클릭 리스너(뒤로가기) */
    fun backBtn(){
        exit.setOnClickListener {
            finish()
        }
    }
}