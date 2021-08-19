package com.example.wsw

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.wsw.api.ApiServicempl
import com.example.wsw.feature.login.LoginActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class RandomMessageDialogFragment : DialogFragment(), View.OnClickListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_random_message, null)
        builder.setView(view)

        var exit = view.findViewById<Button>(R.id.exit)
        exit.setOnClickListener {
            dismiss()
        }

        var btn_like = view.findViewById<ImageButton>(R.id.btn_like)
        var btn_dislike = view.findViewById<ImageButton>(R.id.btn_dislike)
        btn_like.setOnClickListener(this)
        btn_dislike.setOnClickListener(this)

        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }


    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_dislike) {
                ApiServicempl.api.sendDislike().enqueue(object : retrofit2.Callback<Boolean> {
                    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        if (response.body() == true) {

                        } else {
                            Toast.makeText(context, "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                        Log.d("test", t.message.toString())
                    }

                })
            }
            Toast.makeText(context, "소중한 의견 감사합니다 :)", Toast.LENGTH_LONG).show()
            dismiss()
        }
    }
}