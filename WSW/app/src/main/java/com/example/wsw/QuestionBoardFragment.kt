package com.example.wsw

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_random_message.view.*

class QuestionBoardFragment : Fragment() {
    lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = LayoutInflater.from(activity).inflate(R.layout.fragment_question_board, container, false)


        // Return the fragment view/layout
        return mView
    }
}