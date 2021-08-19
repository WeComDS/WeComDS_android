package com.example.wsw

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.api.ApiServicempl
import kotlinx.android.synthetic.main.activity_mypage.*
import kotlinx.android.synthetic.main.activity_random_message.*
import kotlinx.android.synthetic.main.activity_random_message.back
import retrofit2.Call
import retrofit2.Response

class RandomMessageActivity : AppCompatActivity(){

    private val TAG = RandomMessageActivity::class.qualifiedName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_message)

        var random_message = findViewById<ImageView>(R.id.random_message)
        random_message.setOnClickListener { view ->

            ApiServicempl.api.requestRandomMessage()
                    .enqueue(object :retrofit2.Callback<String>{
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            Log.d("aaa",response.body().toString())
                            val intent=Intent(applicationContext,RandomMessageViewActivity::class.java)
                            intent.putExtra("message", response.body())
                            response.body()?.let { Log.d("testtt", it) }
                            startActivity(intent)
                        }

                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Log.d(TAG, t.message.toString())
                        }

                    })

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