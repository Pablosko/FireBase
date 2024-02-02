package com.pablo_daniel.aa3_interficies.clases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.aa3_interficies.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsDataList: MutableList<NewsData> = mutableListOf()

    fun setNewsDataList(list: MutableList<NewsData>) {
        newsDataList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsDataList[position])
    }

    override fun getItemCount(): Int {
        return newsDataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val contentsTextView: TextView = itemView.findViewById(R.id.contentsTextView)

        fun bind(newsData: NewsData) {
            titleTextView.text = newsData.title
            contentsTextView.text = newsData.contents
        }
    }
}
