package com.example.wsw.ui.questionboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.api.ApiServicempl
import com.example.wsw.data.SecretListGetData
import com.example.wsw.data.questionListGetData
import com.example.wsw.ui.secretboard.SecretBoardAdapter
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_question_board.*
import retrofit2.Call
import retrofit2.Response

class QuestionBoardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_question_board, container, false)
        clickFab(view)

        ApiServicempl.api.questionList().enqueue(object: retrofit2.Callback<ArrayList<questionListGetData>> {
            override fun onResponse(
                call: Call<ArrayList<questionListGetData>>,
                response: Response<ArrayList<questionListGetData>>
            ) {
//                var first = response.body()!! //이 문법은 하나의 객체를 가져옵니다..
//                Log.d("성공", first.toString())

                val adapter = QuestionBoardAdapter(view.context, response.body()!!)
                val rcv_questionBoard = view!!.findViewById<RecyclerView>(R.id.rcv_questionBoard)
                rcv_questionBoard.adapter = adapter

                val lm = LinearLayoutManager(view.context)
                rcv_questionBoard.layoutManager = lm
                rcv_questionBoard.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<ArrayList<questionListGetData>>, t: Throwable) {
                t.printStackTrace()
                Log.d("실패",t.message.toString())
            }
        })

        //Adapter연결 : 태영
//        val adapter = QuestionBoardAdapter()
//        val rcv_questionBoard = view!!.findViewById<RecyclerView>(R.id.rcv_questionBoard)
//        rcv_questionBoard.adapter = adapter

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