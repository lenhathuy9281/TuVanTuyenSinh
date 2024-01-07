package com.doan.tuvantuyensinh.ui.chatbot

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doan.tuvantuyensinh.R
import com.doan.tuvantuyensinh.databinding.ItemMessageBinding
import com.doan.tuvantuyensinh.domain.Message

class MessageAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMessageBinding = DataBindingUtil.inflate(inflater, R.layout.item_message, parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.binding.message = message
        with(holder.binding) {
            if (message.isSent) {
                textMessage.background = ContextCompat.getDrawable(root.context, R.drawable.bg_chat_send)
                textMessage.setTextColor(ContextCompat.getColor(root.context, R.color.colorSendText))
                llItemMessage.gravity = Gravity.END
            } else {
                textMessage.background = ContextCompat.getDrawable(root.context, R.drawable.bg_chat_receive)
                textMessage.setTextColor(ContextCompat.getColor(root.context, R.color.colorReceiveText))
                llItemMessage.gravity = Gravity.START
            }
        }

        holder.binding.executePendingBindings()

        // Set background color and text color based on message type

    }

    override fun getItemCount(): Int {
        return messages.size
    }
}