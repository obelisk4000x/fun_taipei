package com.maxma.funtaipei.view.attraction

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxma.funtaipei.R
import com.maxma.funtaipei.base.MainViewModelFactory
import com.maxma.funtaipei.databinding.ActivityAttractionsBinding
import com.maxma.funtaipei.view_model.AttractionsViewModel

class AttractionListActivity : AppCompatActivity() {

    private val viewModel by viewModels<AttractionsViewModel> { MainViewModelFactory() }
    private lateinit var dataBinding: ActivityAttractionsBinding
    private var attractionListAdapter: AttractionListAdapter = AttractionListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_attractions)
        dataBinding.lifecycleOwner = this
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        dataBinding.attractionList.layoutManager = LinearLayoutManager(this)
        dataBinding.attractionList.adapter = attractionListAdapter
    }

    private fun setupObserver() {
        viewModel.attractionList.observe(this, Observer {
            attractionListAdapter.setData(it)
        })
    }
}