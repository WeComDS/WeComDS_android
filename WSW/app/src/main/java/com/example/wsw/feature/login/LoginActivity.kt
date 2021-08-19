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

            var intent = Intent(applicationContext, HomeFragment::class.java)
            startActivity(intent)
        }

        var signup_below = findViewById<TextView>(R.id.signup_below)
        signup_below.setOnClickListener {
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)

            signup_below.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)

    }
}