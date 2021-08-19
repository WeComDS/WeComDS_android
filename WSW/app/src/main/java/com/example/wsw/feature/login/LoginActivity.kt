package com.example.wsw.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wsw.MainActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import com.example.wsw.data.LoginResponseData
import com.example.wsw.feature.signup.SignupActivity
import com.example.wsw.ui.home.HomeFragment
import retrofit2.Call
import retrofit2.Response

class  LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var signup_below = findViewById<TextView>(R.id.signup_below)
        signup_below.setOnClickListener {
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)

            signup_below.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


        email = findViewById<EditText>(R.id.email)
        password = findViewById<EditText>(R.id.password)
        login = findViewById<Button>(R.id.login)

        requestLogin()
    }
    private fun requestLogin(){
        login.setOnClickListener {
            ApiServicempl.api.requestLogin(email.text.toString(), password.text.toString())
                    .enqueue(object :retrofit2.Callback<LoginResponseData>{
                        override fun onResponse(call: Call<LoginResponseData>, response: Response<LoginResponseData>) {
                            response.body()?.let { it1 -> AppData.prefs.setInt("user_id", it1.user_id) }

                            var intent= Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }

                        override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                            Toast.makeText(applicationContext,"로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인해주세요.",Toast.LENGTH_LONG)
                                    .show()
                        }

                    })


        }
    }
}