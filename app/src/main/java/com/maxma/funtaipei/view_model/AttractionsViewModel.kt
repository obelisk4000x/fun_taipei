package com.maxma.funtaipei.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxma.funtaipei.model.Attraction
import com.maxma.funtaipei.repository.AttractionsRepository
import kotlinx.coroutines.launch

class AttractionsViewModel(private val repository: AttractionsRepository) : ViewModel() {

    var attractionList: MutableLiveData<List<Attraction>> = MutableLiveData<List<Attraction>>()
        private set

    init {
        viewModelScope.launch {
            attractionList.postValue(repository.getAttractions("en", "12"))
        }
    }
}