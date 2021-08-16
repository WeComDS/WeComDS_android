package com.example.wsw.ui.secretboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.ui.questionboard.QuestionBoardAdapter
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecretBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            LayoutInflater.from(activity).inflate(R.layout.fragment_secret_board, container, false)

        clickFab(view)

        //Adapter연결 : 태영
        val adapter = SecretBoardAdapter()
        val rcv_secretBoard = view!!.findViewById<RecyclerView>(R.id.rcv_secretBoard)
        rcv_secretBoard.adapter = adapter

        return view
    }

    private fun clickFab(view: View) {
        val fab_write = view.findViewById<FloatingActionButton>(R.id.fab_write)
        fab_write.setOnClickListener {
            var intent = Intent(view.context, SecretBoardWriteActivity::class.java)
            startActivity(intent)
        }
    }

}