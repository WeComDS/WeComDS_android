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
import com.example.wsw.data.SecretListGetData
import com.example.wsw.data.questionListGetData

class QuestionBoardAdapter(val context: Context, val question_list:ArrayList<questionListGetData>) : RecyclerView.Adapter<QuestionBoardAdapter.QuestionBoardViewHolder>() {

    fun imakeformat(date:String):String{
        //date를 받아온다
        var date = date

        //요일
        var MM = date.substring(5,7)
        var DD = date.substring(8,10)

        //시간
        var h = date.substring(11,13)
        var m = date.substring(14,16)

        //완성
        var complete = MM+"/"+DD+" "+h+":"+m

        return complete
    }

    // 아이템 개수만큼 View 생성해주는 칭구
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_question_board, parent, false)
        return QuestionBoardViewHolder(inflatedView)
    }

    //생성된 View에 보여줄 데이터 설정해주는 칭구
    override fun onBindViewHolder(holder: QuestionBoardViewHolder, position: Int) {
        holder.bind(question_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, QuestionBoardPostActivity::class.java)

            intent.putExtra("question_id",question_list[position].que_id)
            intent.putExtra("question_title",question_list[position].que_title)
            intent.putExtra("question_date", imakeformat(question_list[position].que_date))
            intent.putExtra("question_like", question_list[position].que_like)
            intent.putExtra("question_CMcount",question_list[position].que_CMcount)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    //보여줄 아이템 개수가 몇개인지 알려주는 칭구
    override fun getItemCount(): Int{
        return question_list.size
    }

    //ViewHolder 단위객체로 View의 데이터 설정해주는 칭구
    inner class QuestionBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //test : 태영
        val date: TextView = itemView.findViewById<TextView>(R.id.tv_que_time)
        val title: TextView = itemView.findViewById<TextView>(R.id.tv_contentPreview)
        val like: TextView = itemView.findViewById<TextView>(R.id.text_count_like)
        val comm: TextView = itemView.findViewById<TextView>(R.id.text_count_comm)

        fun bind(item: questionListGetData, context: Context){
            var getTitle = item.que_title
            if(getTitle.length > 30){
                title.text = getTitle.substring(0,30).plus("...")
            }else{
                title.text = getTitle
            }
            like.text = item.que_like.toString()
            comm.text = item.que_CMcount.toString()
            date.text = imakeformat(item.que_date)
        }
    }
}