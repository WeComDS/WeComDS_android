package com.example.wsw.ui.reviewboard

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
import com.example.wsw.data.reviewListGetData
import com.example.wsw.ui.secretboard.SecretBoardAdapter
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Response

class ReviewBoardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_review_board, container, false)
        clickFab(view)

        ApiServicempl.api.reviewList().enqueue(object: retrofit2.Callback<ArrayList<reviewListGetData>> {
            override fun onResponse(
                call: Call<ArrayList<reviewListGetData>>,
                response: Response<ArrayList<reviewListGetData>>
            ) {
//                var first = response.body()!! //이 문법은 하나의 객체를 가져옵니다..
//                Log.d("성공", first.toString())

                val adapter = ReviewBoardAdapter(view.context, response.body()!!)
                val rcv_reviewBoard = view!!.findViewById<RecyclerView>(R.id.rcv_reviewBoard)
                rcv_reviewBoard.adapter = adapter

                val lm = LinearLayoutManager(view.context)
                rcv_reviewBoard.layoutManager = lm
                rcv_reviewBoard.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<ArrayList<reviewListGetData>>, t: Throwable) {
                t.printStackTrace()
                Log.d("실패",t.message.toString())
            }
        })

        //Adapter연결 : 태영
//        val adapter = ReviewBoardAdapter()
//        val rcv_reviewBoard = view!!.findViewById<RecyclerView>(R.id.rcv_reviewBoard)
//        rcv_reviewBoard.adapter = adapter

        return view
    }

    private fun clickFab(view: View) {
        val fab_write = view.findViewById<FloatingActionButton>(R.id.fab_write)
        fab_write.setOnClickListener {
            var intent = Intent(view.context, ReviewBoardWriteActivity::class.java)
            startActivity(intent)
        }
    }
}