package com.example.wsw.ui.questionboard

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R

class QuestionBoardAdapter() : RecyclerView.Adapter<QuestionBoardAdapter.QuestionBoardViewHolder>() {

    // 아이템 개수만큼 View 생성해주는 칭구
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_question_board, parent, false)
        return QuestionBoardViewHolder(inflatedView)
    }

    //생성된 View에 보여줄 데이터 설정해주는 칭구
    override fun onBindViewHolder(holder: QuestionBoardViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, QuestionBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    //보여줄 아이템 개수가 몇개인지 알려주는 칭구
    override fun getItemCount() = 10

    //ViewHolder 단위객체로 View의 데이터 설정해주는 칭구
    class QuestionBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //test : 태영
        private val content: TextView = itemView.findViewById(R.id.tv_contentPreview)
        private val like: TextView = itemView.findViewById(R.id.text_count_like)
        private val comm: TextView = itemView.findViewById(R.id.text_count_comm)

        fun bind(item: QuestionItem){
            content.text = item.content
            like.text = item.like.toString()
            comm.text = item.comm.toString()
        }
    }
}