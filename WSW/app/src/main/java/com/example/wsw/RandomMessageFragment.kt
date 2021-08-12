package com.example.wsw

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_random_message.*
import kotlinx.android.synthetic.main.fragment_random_message.view.*

class RandomMessageFragment : Fragment(){
    lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = LayoutInflater.from(activity).inflate(R.layout.fragment_random_message, container, false)

        mView.random_message.setOnClickListener { view ->
            val intent=Intent(activity,RandomMessageViewFragment::class.java)
            startActivity(intent)
        }

        // Return the fragment view/layout
        return mView
    }
}