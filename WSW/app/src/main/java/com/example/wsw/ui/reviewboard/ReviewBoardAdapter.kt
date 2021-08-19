package com.example.wsw.ui.reviewboard

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.data.reviewListGetData
import com.example.wsw.ui.questionboard.QuestionBoardPostActivity
import org.w3c.dom.Text

class ReviewBoardAdapter(val context:Context, val review_list:ArrayList<reviewListGetData>) : RecyclerView.Adapter<ReviewBoardAdapter.ReviewBoardViewHolder>(){

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_review_board, parent, false)
        return ReviewBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ReviewBoardAdapter.ReviewBoardViewHolder, position: Int) {
        holder.bind(review_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ReviewBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount(): Int{
        return review_list.size
    }

    inner class ReviewBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val review_company = itemView.findViewById<TextView>(R.id.tv_company) //회사
        val review_content = itemView.findViewById<TextView>(R.id.tv_contentPreview)
        val review_like = itemView.findViewById<TextView>(R.id.txt_review_like)
        val review_comm = itemView.findViewById<TextView>(R.id.txt_review_comm)
        val review_date = itemView.findViewById<TextView>(R.id.tv_time)

        fun bind(item: reviewListGetData, context: Context){
            var rev_content = item.review_content

            if (rev_content.length > 30){
                review_content.text = rev_content.substring(rev_content.indexOf(":")+1,30).plus("...")
            }else{
                review_content.text = rev_content.substring(rev_content.indexOf(":")+1,rev_content.length)
            }
            review_company.text = rev_content.substring(0,rev_content.indexOf(":"))
            review_like.text = item.review_like.toString()
            review_comm.text = item.reviewe_CMcount.toString()
            review_date.text = imakeformat(item.review_date)
        }

    }

}