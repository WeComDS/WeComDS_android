package com.example.wsw

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RandomMessageViewActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_message_view)

        var btn_evaluation = findViewById<Button>(R.id.btn_evaluation)
        btn_evaluation.setOnClickListener {
            setDialog()
        }

    }
    private fun setDialog(){
        val dialog = RandomMessageDialogFragment()
        dialog.show(supportFragmentManager, "RandomMessageDialogFragment")
    }


}