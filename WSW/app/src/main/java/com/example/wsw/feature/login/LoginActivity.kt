package com.example.wsw.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
import javax.security.auth.callback.Callback

class  LoginActivity : AppCompatActivity(), TextWatcher {

    private val email: EditText by lazy {
        findViewById<EditText>(R.id.email)
    }
    private val password: EditText by lazy {
        findViewById<EditText>(R.id.password)
    }

<<<<<<< HEAD
=======
class  LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button

>>>>>>> 2c52822f29f44ba519c5bab92d10dc8c67c4bdee
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

<<<<<<< HEAD
        email.addTextChangedListener(this)
        password.addTextChangedListener(this)
=======
        login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
>>>>>>> 2c52822f29f44ba519c5bab92d10dc8c67c4bdee

        requestLogin()

        var signup_below = findViewById<TextView>(R.id.signup_below)
        signup_below.setOnClickListener{

            signup_below.setTextColor(ContextCompat.getColor(this, R.color.black))
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)

        }

<<<<<<< HEAD
    }

    private fun requestLogin(){
        var login = findViewById<Button>(R.id.login)
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

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if(!email.text.isEmpty() && !password.text.isEmpty()){
            //로그인버튼활성화
=======
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
>>>>>>> 2c52822f29f44ba519c5bab92d10dc8c67c4bdee
        }

        override fun afterTextChanged(s: Editable) {}
    }

    override fun afterTextChanged(s: Editable?) {
    }
}