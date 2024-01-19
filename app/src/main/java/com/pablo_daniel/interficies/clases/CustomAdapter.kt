package com.pablo_daniel.interficies.clases

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.interficies.R

class CustomAdapter(private val context: Context, private val items: List<ListItem>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.imageResId)
        holder.imageView.setOnClickListener {
            // Verificar si la función onClick no es nula antes de llamarla
            item.onClick?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
