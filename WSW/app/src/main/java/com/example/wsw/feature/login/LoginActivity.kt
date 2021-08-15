package com.example.wsw.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wsw.R
import com.example.wsw.feature.signup.SignupActivity
import com.example.wsw.ui.home.HomeFragment

class  LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var login = findViewById<Button>(R.id.login)
        login.setOnClickListener {

            var intent= Intent(applicationContext, HomeFragment::class.java)
            startActivity(intent)
        }

        var signup_below = findViewById<TextView>(R.id.signup_below)
        signup_below.setOnClickListener{
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)

            signup_below.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)

        //val id = email.text.toString()
        //val pw = password.text.toString()

        email.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //edittext 다 채워졌는지check
                if(!email.text.isEmpty()){
                    //테두리색 바꾸기
                }

            }

        })

        password.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!password.text.isEmpty()){
                    //테두리색 바꾸기
                }

            }

        })

        if(!email.text.isEmpty() && !password.text.isEmpty()){
            //로그인버튼활성화
        }
    }
}