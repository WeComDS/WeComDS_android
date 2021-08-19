package com.example.wsw.ui.secretboard

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.data.SecretListGetData
import com.example.wsw.ui.reviewboard.ReviewBoardAdapter
import com.example.wsw.ui.reviewboard.ReviewBoardPostActivity
import com.example.wsw.ui.secretboard.post.SecretBoardPostActivity
import org.w3c.dom.Text
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SecretBoardAdapter(val context: Context, val secret_list:ArrayList<SecretListGetData>) : RecyclerView.Adapter<SecretBoardAdapter.SecretBoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecretBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_secret_board, parent, false)
        return SecretBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SecretBoardViewHolder, position: Int) {
        holder.bind(secret_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, SecretBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount(): Int{
        return secret_list.size
    }

    inner class SecretBoardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val secret_content = itemView.findViewById<TextView>(R.id.tv_contentPreview)
        val secret_like = itemView.findViewById<TextView>(R.id.tv_secret_like)
        val secret_comm = itemView.findViewById<TextView>(R.id.tv_secret_comm)
        val secret_date = itemView.findViewById<TextView>(R.id.tv_time)

        fun bind(sitem: SecretListGetData, context: Context){
            secret_content.text = sitem.sec_content
            secret_like.text = sitem.sec_like.toString()
            secret_comm.text = sitem.sec_CMcount.toString()
            secret_date.text = sitem.sec_date
        }
    }
}