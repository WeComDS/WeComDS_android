package com.example.wsw.ui.secretboard

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecretBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_secret_board, parent, false)
        return SecretBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SecretBoardViewHolder, position: Int) {
        holder.bind(secret_list[position], context)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, SecretBoardPostActivity::class.java)


            intent.putExtra("secret_content", secret_list[position].sec_content)
            intent.putExtra("secret_CMcount", secret_list[position].sec_CMcount)
            intent.putExtra("secret_like", secret_list[position].sec_like)
            intent.putExtra("secret_date", imakeformat(secret_list[position].sec_date))


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
            secret_date.text = imakeformat(sitem.sec_date)
        }
    }
}