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
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById<Button>(R.id.login)
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

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        email.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)


    }
    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = email!!.text.toString().trim { it <= ' ' }
            val passwordInput = password!!.text.toString().trim { it <= ' ' }
            login!!.isEnabled = !usernameInput.isEmpty() && !passwordInput.isEmpty()

            if(!email.text.isEmpty() && !password.text.isEmpty()){
                //로그인버튼활성화
                //login.background=ContextCompat.getColor(login, R.color.ColorCompleteSendSelected)
                //login.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
            }
        }

        override fun afterTextChanged(s: Editable) {}
    }
}