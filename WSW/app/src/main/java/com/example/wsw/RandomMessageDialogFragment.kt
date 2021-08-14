package com.example.wsw

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class RandomMessageDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_random_message, null)
        builder.setView(view)

        var exit = view.findViewById<Button>(R.id.exit)
        exit.setOnClickListener {
            dismiss()
        }

        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    private fun emojiClicked(v: View){
        if(v.id == R.id.btn_like){
            Toast.makeText(context, "좋아요를 선택하셨습니다.", Toast.LENGTH_LONG).show()
            dismiss()
        }else{
            Toast.makeText(context, "싫어요를 선택하셨습니다.", Toast.LENGTH_LONG).show()
            dismiss()
        }
    }
}