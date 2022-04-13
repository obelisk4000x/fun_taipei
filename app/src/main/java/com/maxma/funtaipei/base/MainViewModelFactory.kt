package com.maxma.funtaipei.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxma.funtaipei.repository.AttractionsRepository
import com.maxma.funtaipei.view_model.AttractionsViewModel
import com.maxma.funtaipei.view_model.NewsViewModel

class MainViewModelFactory : ViewModelProvider.Factory {
    private val attractionsRepository: AttractionsRepository = AttractionsRepository()

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(AttractionsViewModel::class.java) -> AttractionsViewModel(
                    attractionsRepository
                )
                isAssignableFrom(NewsViewModel::class.java) -> NewsViewModel()
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}