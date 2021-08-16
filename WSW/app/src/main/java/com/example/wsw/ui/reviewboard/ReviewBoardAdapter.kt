package com.example.wsw.ui.reviewboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.ui.questionboard.QuestionBoardPostActivity

class ReviewBoardAdapter() : RecyclerView.Adapter<ReviewBoardAdapter.ReviewBoardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_review_board, parent, false)
        return ReviewBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ReviewBoardAdapter.ReviewBoardViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ReviewBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount() = 10

    class ReviewBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}