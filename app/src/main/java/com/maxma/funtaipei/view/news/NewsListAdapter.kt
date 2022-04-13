package com.maxma.funtaipei.view.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxma.funtaipei.databinding.NewsRecyclerItemBinding
import com.maxma.funtaipei.model.News

class NewsListAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    private var newsList: MutableList<News> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsRecyclerItemBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList.get(position))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setData(news: List<News>) {
        newsList.clear()
        newsList.addAll(news)
        notifyDataSetChanged()
    }
}