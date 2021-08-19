package com.example.wsw.ui.studyboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wsw.MainActivity
import com.example.wsw.R
import com.example.wsw.RandomMessageViewActivity
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.AppData
import kotlinx.android.synthetic.main.activity_study_board_write.*
import retrofit2.Call
import retrofit2.Response

class StudyBoardWriteActivity : AppCompatActivity(){
    var study_style:String = "비대면"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_board_write)

        var exit = findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener{
            finish()
        }

        var et_studyTitle = findViewById<EditText>(R.id.et_studyTitle)
        var et_studyInfo = findViewById<EditText>(R.id.et_studyInfo)
        var et_studyNotice = findViewById<EditText>(R.id.et_studyNotice)
        var et_headcount = findViewById<EditText>(R.id.et_headcount)


        setRadioButton()
        completeClicked()


    }

    private fun setRadioButton(){

        var radioGroup_studyWay = findViewById<RadioGroup>(R.id.radioGroup_studyWay)


        radioGroup_studyWay.setOnCheckedChangeListener{ radioGroup, checkedId ->
            when(checkedId){
                R.id.radio_online ->{
                    study_style = "비대면"
                }
                R.id.radio_offline ->{
                    study_style = "대면"
                }
            }
            Log.d("test",study_style)
        }
    }

    private fun completeClicked(){
        var btn_complete=findViewById<Button>(R.id.btn_complete)
        btn_complete.setOnClickListener {

            ApiServicempl.api.studyWrite(
                    AppData.prefs.getInt("user_id"),  //로그인 하면 id값이 저장되어 있기 때문에 그걸로 전송
                    //1,
                    et_studyTitle.text.toString(),
                    "2021-08-18 12:57:00",
                    study_style,
                    et_headcount.text.toString().toInt(),
                    et_studyInfo.text.toString(),
                    et_studyNotice.text.toString(),
                    "모집중",
                    0
            ).enqueue(object: retrofit2.Callback<Boolean>{
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    if(response.body() == true) {

                    }else{
                        Toast.makeText(applicationContext, "오류가 발생했습니다. 나중에 다시 시도해주세요.", Toast.LENGTH_LONG)
                                .show()
                    }
                }

                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("실패",t.message.toString())
                }

            })

            //btn_complete.background= ContextCompat.getDrawable(this, R.drawable.round_complete_button_selected)
            //btn_complete.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        }
    }
}