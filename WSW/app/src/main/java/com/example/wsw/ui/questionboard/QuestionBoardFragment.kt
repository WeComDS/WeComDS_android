package com.example.wsw.ui.questionboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wsw.R
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class QuestionBoardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question_board, container, false)
        clickFab(view)
        return view
    }

    private fun clickFab(view: View) {
        val fab_write = view.findViewById<FloatingActionButton>(R.id.fab_write)
        fab_write.setOnClickListener {
            var intent = Intent(view.context, QuestionBoardWriteActivity::class.java)
            startActivity(intent)
        }
    }
}