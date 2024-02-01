package com.pablo_daniel.aa3_interficies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.dataClasses.DbMessage
import com.pablo_daniel.aa3_interficies.firebase.FB

class MessagesAdapter(private val table: RecyclerView) : RecyclerView.Adapter<MessageViewHolder>() {

    var messages = mutableListOf<DbMessage>()

    init {
        initTableListener()
    }

    private fun initTableListener() {
        FB.db.onTableChange<DbMessage>(DbMessage().getTable()) { updateMessages ->
            updateMessages.sortBy { message -> message.createDate }
            val count = messages.size
            val newCount = updateMessages.size
            val diff = newCount - count

            messages = updateMessages
            if (diff > 0) {
                notifyItemRangeInserted(count, diff)
            } else {
                notifyDataSetChanged()
            }
            table.scrollToPosition(newCount - 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = MessageViewHolder(layoutInflater.inflate(R.layout.chat_cell, parent, false))

        viewHolder.itemView.setOnClickListener {
            // Lógica de clic aquí
        }
        return viewHolder
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.setUpWithMessage(messages[position])
    }

    fun addMessage(text: String?, imageUrl: String?) {
        val dbMessage = DbMessage(null, FB.authentication.getUser()?.id, text, imageUrl)
        FB.db.save(dbMessage, onSuccess = {
            // Manejar éxito aquí
        }, onFailure = {
            // Manejar fallo aquí
        })
    }
}