package com.example.wsw.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wsw.feature.login.LoginActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import retrofit2.Call
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var login_below = findViewById<TextView>(R.id.login_below)
        login_below.setOnClickListener{
            var intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)

            login_below.setTextColor(ContextCompat.getColor(this, R.color.black))


        }

        var btn_signup = findViewById<Button>(R.id.btn_signup)
        btn_signup.setOnClickListener {
            ApiServicempl.api.requestRegister("1","2","3",1)
                    .enqueue(object :retrofit2.Callback<Boolean>{
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if (response.body() == true) {
                                var intent = Intent(applicationContext, LoginActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(applicationContext, "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Boolean>, t: Throwable) {
                            Log.d("test", t.message.toString())
                            Toast.makeText(applicationContext, "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_LONG).show()
                        }


                    })
        }

    }
}

