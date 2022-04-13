package com.maxma.funtaipei.repository

import android.util.Log
import com.maxma.funtaipei.base.ApiManager
import com.maxma.funtaipei.model.Attraction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AttractionsRepository {

    suspend fun getAttractions(lang: String, categoryIds: String): List<Attraction> = withContext(
        Dispatchers.IO) {
        val response = ApiManager.service.getAttractions(lang, categoryIds, 1)
        if (response.isSuccessful) {
            val body = response.body()!!
            return@withContext body.data
        } else {
            throw Exception(response.errorBody()?.charStream()?.readText())
        }
    }
}