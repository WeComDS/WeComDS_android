package com.example.wsw.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.wsw.feature.login.LoginActivity
import com.example.wsw.R

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


    }
}