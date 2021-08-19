package com.example.wsw.ui.home.mypage.message

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.data.messagelist.MessageListData
import kotlinx.android.synthetic.main.listitem_message.view.*

class MessageAdapter(val msglist:List<MessageListData>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_message,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) {
        val item = msglist[position]
        holder.setItem(item)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, MessageListActivity::class.java)
            startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = msglist.count()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: MessageListData){
            itemView.txtMessageNick.text = item.mes_sendID
            itemView.txtMessageContents.text = item.mes_content
        }
    }
}