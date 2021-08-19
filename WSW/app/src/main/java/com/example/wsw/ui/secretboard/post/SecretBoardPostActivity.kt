package com.example.wsw.ui.secretboard.post

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.feature.signup.SignupActivity
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SecretBoardPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_board_post)

        //getExtra
        var secret_id = intent.getIntExtra("secret_id",0)
        var secret_content = intent.getStringExtra("secret_content")
//        var secret_CMcount = intent.getIntExtra("secret_CMcount",0)
//        var secret_like = intent.getIntExtra("secret_like", 0)
        var secret_date = intent.getStringExtra("secret_date")

        //findId
        var txt_sec_date = findViewById<TextView>(R.id.txt_sec_date)
        var content = findViewById<TextView>(R.id.content)

        //연결
        txt_sec_date.text = secret_date
        content.text = secret_content

        var Three_dots = findViewById<ImageView>(R.id.img_menu)

        Three_dots.setOnClickListener {
            var pop = PopupMenu(applicationContext, it)

            menuInflater.inflate(R.menu.menu_study_recruitment, pop.menu)
            pop.show()
            pop.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu1 -> {
                        Log.d("MainActivity", "눌리는중1")
                        ApiServicempl.api.deleteSecretPost(secret_id).enqueue(object : retrofit2.Callback<Void>{
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                Log.d("secretDelete", "삭제: $secret_id")
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Log.d("secretDelete", "삭제실패")
                            }

                        })
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
        }

        var btn_recommend = findViewById<ImageView>(R.id.btn_recommend)
        btn_recommend.setOnClickListener {
            btn_recommend.setImageResource(R.drawable.ic_recommend_white)
            btn_recommend.setBackgroundResource(R.drawable.round_recommend_scrap_selected)
        }


    }
}