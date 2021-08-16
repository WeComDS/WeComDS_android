package com.example.wsw.ui.studyboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.ui.reviewboard.ReviewBoardAdapter
import com.example.wsw.ui.reviewboard.ReviewBoardPostActivity

class StudyBoardAdapter() : RecyclerView.Adapter<StudyBoardAdapter.StudyBoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudyBoardAdapter.StudyBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_study_board, parent, false)
        return StudyBoardAdapter.StudyBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: StudyBoardAdapter.StudyBoardViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, StudyBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount() = 10

    class StudyBoardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}