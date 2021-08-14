package com.example.wsw.ui.studyboard

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.wsw.R
import kotlinx.android.synthetic.main.dialog_study_apply.view.*

class ApplyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_study_apply, null)
        builder.setView(view)

        var exit = view.findViewById<Button>(R.id.exit)
        exit.setOnClickListener {
            dismiss()
        }

        var btn_apply = view.findViewById<Button>(R.id.btn_apply)
        btn_apply.setOnClickListener {

        }

        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }
}