package com.example.wsw

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import retrofit2.Call
import retrofit2.Response

class RandomMessageWriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_message_write)
        var et_randomMessage = findViewById<EditText>(R.id.et_randomMessage)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener {
            finish()
        }

        var btn_complete = findViewById<Button>(R.id.btn_complete)
        btn_complete.setOnClickListener {
            btn_complete.background =
                    ContextCompat.getDrawable(this, R.drawable.round_complete_button_selected)
            btn_complete.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

            ApiServicempl.api.sendRandomMessage(AppData.prefs.getInt("user_id"), et_randomMessage.text.toString())
                    .enqueue(object : retrofit2.Callback<Boolean>{
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if(response.body() == true) {
                                Log.d("test","aaaaaaa")
                                finish()
                                Toast.makeText(applicationContext, "메세지가 전달되었습니다 :)", Toast.LENGTH_LONG).show()
                            }else{
                                Toast.makeText(applicationContext, "오류가 발생했어요. 나중에 다시 시도해주세요 :(", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Boolean>, t: Throwable) {
                            Log.d("test", t.message.toString())
                        }

                    })
        }
    }
}