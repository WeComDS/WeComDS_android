package com.example.wsw.ui.studyboard

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
import com.example.wsw.data.SecretListGetData
import com.example.wsw.data.StudyListGetData
import com.example.wsw.ui.reviewboard.ReviewBoardAdapter
import com.example.wsw.ui.reviewboard.ReviewBoardPostActivity

class StudyBoardAdapter(val context: Context, val study_list:ArrayList<StudyListGetData>) : RecyclerView.Adapter<StudyBoardAdapter.StudyBoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudyBoardAdapter.StudyBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_study_board, parent, false)
        return StudyBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: StudyBoardAdapter.StudyBoardViewHolder, position: Int) {
        holder.bind(study_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, StudyBoardPostActivity::class.java)
            intent.putExtra("title",study_list[position].study_title)
            intent.putExtra("style",study_list[position].study_style)
            intent.putExtra("apply",study_list[position].study_applycount.toString())
            intent.putExtra("headcount",study_list[position].study_headcount.toString())
            intent.putExtra("state",study_list[position].study_state)
            intent.putExtra("info",study_list[position].study_introduce)
            intent.putExtra("notice",study_list[position].study_notice)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount() = study_list.size

    public fun imakeformat(date:String):String{
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

    inner class StudyBoardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val study_place = itemView.findViewById<TextView>(R.id.tv_studyPlace)
        val study_postDate = itemView.findViewById<TextView>(R.id.tv_postDate)
        val study_title = itemView.findViewById<TextView>(R.id.tv_studyTitle)
        val study_apply = itemView.findViewById<TextView>(R.id.tv_studyApply)

        fun bind(sitem: StudyListGetData, context: Context){
            study_place.text = sitem.study_style.toString()
            study_postDate.text = imakeformat(sitem.study_date)
            study_title.text = sitem.study_title.toString()
            study_apply.text = sitem.study_applycount.toString()+"/"+sitem.study_headcount.toString()
        }
    }
}