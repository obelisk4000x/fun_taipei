package com.maxma.funtaipei.view.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxma.funtaipei.R
import com.maxma.funtaipei.databinding.ActivityNewsBinding
import com.maxma.funtaipei.view_model.NewsViewModel
import java.util.*

class NewsActivity : AppCompatActivity(), Observer {
    override fun update(observable: Observable?, arg: Any?) {
        if (observable is NewsViewModel) {
            newsListAdapter.setData(observable.getNewsList())
        }
    }

    private lateinit var dataBinding: ActivityNewsBinding
    private var viewModel: NewsViewModel = NewsViewModel()
    private var newsListAdapter: NewsListAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
        setupObserver(viewModel)
        setupUI()
    }

    private fun setupUI() {
        dataBinding.newsList.layoutManager = LinearLayoutManager(this)
        dataBinding.newsList.adapter = newsListAdapter
    }

    private fun setupObserver(observable: Observable) {
        observable.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.reset()
    }
}