package com.example.wsw.ui.studyboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.SecretListGetData
import com.example.wsw.data.StudyListGetData
import com.example.wsw.ui.questionboard.QuestionBoardAdapter
import com.example.wsw.ui.secretboard.SecretBoardAdapter
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Response

class StudyBoardFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_study_board, container,false)

        clickFab(view)


        ApiServicempl.api.studyList().enqueue(object :retrofit2.Callback<ArrayList<StudyListGetData>>{
            override fun onResponse(call: Call<ArrayList<StudyListGetData>>, response: Response<ArrayList<StudyListGetData>>) {
                val adapter = StudyBoardAdapter(view.context, response.body()!!)
                val rcv_studyBoard = view!!.findViewById<RecyclerView>(R.id.rcv_studyBoard)
                rcv_studyBoard.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<StudyListGetData>>, t: Throwable) {
                t.printStackTrace()
                Log.d("실패",t.message.toString())
            }

        })

        return view

    }

    private fun clickFab(view: View) {
        val fab_write = view.findViewById<FloatingActionButton>(R.id.fab_write)
        fab_write.setOnClickListener {
            var intent = Intent(view.context, StudyBoardWriteActivity::class.java)
            startActivity(intent)
        }
    }
}