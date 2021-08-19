package com.example.wsw.ui.secretboard

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
import com.example.wsw.api.ApiService
import com.example.wsw.api.ApiServicempl
import com.example.wsw.api.ApiServicempl.api
import com.example.wsw.data.SecretListGetData
import com.example.wsw.ui.secretboard.post.SecretBoardWriteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.reflect.typeOf

class SecretBoardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            LayoutInflater.from(activity).inflate(R.layout.fragment_secret_board, container, false)

        clickFab(view)


        ApiServicempl.api.secretList().enqueue(object: retrofit2.Callback<ArrayList<SecretListGetData>> {
            override fun onResponse(
                call: Call<ArrayList<SecretListGetData>>,
                response: Response<ArrayList<SecretListGetData>>
            ) {
                var first = response.body()!! //이 문법은 하나의 객체를 가져옵니다..
                Log.d("성공", first.toString())

                val adapter = SecretBoardAdapter(view.context, response.body()!!)
                val rcv_secretBoard = view!!.findViewById<RecyclerView>(R.id.rcv_secretBoard)
                rcv_secretBoard.adapter = adapter

                val lm = LinearLayoutManager(view.context)
                rcv_secretBoard.layoutManager = lm
                rcv_secretBoard.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<ArrayList<SecretListGetData>>, t: Throwable) {
                t.printStackTrace()
                Log.d("실패",t.message.toString())
            }
        })

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