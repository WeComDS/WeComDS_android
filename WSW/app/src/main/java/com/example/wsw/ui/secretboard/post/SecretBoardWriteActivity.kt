package com.example.wsw.ui.secretboard.post

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.MainActivity
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import com.example.wsw.data.SecretListGetData
import com.example.wsw.feature.login.LoginActivity
import com.example.wsw.ui.secretboard.SecretBoardFragment
import com.jakewharton.threetenabp.AndroidThreeTen
import java.time.LocalDateTime
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit;
import retrofit2.Call
import retrofit2.Response

class SecretBoardWriteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_board_write)

        AndroidThreeTen.init(this)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener{
            finish()
        }

        var current = org.threeten.bp.LocalDateTime.now()
        val formatter = DateTimeFormatter.ISO_DATE_TIME

        var user_id = 1
        var sec_content = findViewById<EditText>(R.id.et_secretPost)
        var sec_date = current.format(formatter).toString()
        var sec_CMcount = 0
        var sec_like = 0


        var btn_complete = findViewById<Button>(R.id.btn_complete)
        btn_complete.setOnClickListener {
//            btn_complete.background=ContextCompat.getDrawable(this, R.drawable.round_complete_button_selected)
//            btn_complete.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

            ApiServicempl.api.secretPost(
                user_id,
                sec_content.text.toString(),
                sec_date,
                sec_CMcount,
                sec_like
            )
                .enqueue(object : retrofit2.Callback<Boolean> {
                    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        if(response.body() == true){
                            Log.d("onResponse", "성공")
                            var intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Log.d("onResponse", "실패")
                        }
                    }
                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                        Log.d("onResponse",t.message.toString())
                        var intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    }

                }

                )
        }

    }
}