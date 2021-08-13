package com.example.wsw.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.wsw.R
import com.example.wsw.feature.signup.SignupActivity

class  LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var signup_below = findViewById<TextView>(R.id.signup_below)
        signup_below.setOnClickListener{
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}