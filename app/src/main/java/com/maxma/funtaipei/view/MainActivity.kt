package com.maxma.funtaipei.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.maxma.funtaipei.R
import com.maxma.funtaipei.databinding.ActivityMainBinding
import com.maxma.funtaipei.view.attraction.AttractionsActivity
import com.maxma.funtaipei.view.news.NewsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        dataBinding.attractionsButton.setOnClickListener {
            val intent = Intent(applicationContext, AttractionsActivity::class.java).apply {
            }
            startActivity(intent)
        }

        dataBinding.eventButton.setOnClickListener {
            val intent = Intent(applicationContext, NewsActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}