package com.example.wsw.ui.secretboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wsw.R
import com.example.wsw.ui.reviewboard.ReviewBoardAdapter
import com.example.wsw.ui.reviewboard.ReviewBoardPostActivity
import com.example.wsw.ui.secretboard.post.SecretBoardPostActivity


class SecretBoardAdapter() : RecyclerView.Adapter<SecretBoardAdapter.SecretBoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecretBoardViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_secret_board, parent, false)
        return SecretBoardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SecretBoardViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, SecretBoardPostActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }

    override fun getItemCount() = 10

    class SecretBoardViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

    }
}