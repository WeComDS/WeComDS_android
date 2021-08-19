package com.example.wsw.ui.home.mypage.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.data.messagelist.MessageListData
import kotlinx.android.synthetic.main.listitem_message.view.*
import kotlinx.android.synthetic.main.listitem_message_all.view.*

class MessageListAdapter(val msglist:List<MessageListData>) : RecyclerView.Adapter<MessageListAdapter.ViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_message_all,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageListAdapter.ViewHolder, position: Int) {
        val item = msglist[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int = msglist.count()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: MessageListData){
            itemView.txtListItemSendOrReceive.text = item.mes_sendID
            itemView.txtListItemContents.text = item.mes_content
            itemView.txtListItemTime.text = imakeformat(item.mes_date)
        }
    }
}