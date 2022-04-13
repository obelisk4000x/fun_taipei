package com.maxma.funtaipei.view.news

import androidx.recyclerview.widget.RecyclerView
import com.maxma.funtaipei.databinding.NewsRecyclerItemBinding
import com.maxma.funtaipei.model.News

class NewsViewHolder(itemBinding: NewsRecyclerItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    private var viewBinding: NewsRecyclerItemBinding = itemBinding

    fun bind(news: News) {
        viewBinding.news = news
    }
}