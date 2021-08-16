package com.example.wsw.ui.questionboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_question_board.*

class QuestionBoardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question_board, container, false)
        clickFab(view)

        //Adapter연결 : 태영
        val adapter = QuestionBoardAdapter()
        val rcv_questionBoard = view!!.findViewById<RecyclerView>(R.id.rcv_questionBoard)
        rcv_questionBoard.adapter = adapter

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