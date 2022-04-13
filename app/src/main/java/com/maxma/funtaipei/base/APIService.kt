package com.maxma.funtaipei.base

import com.maxma.funtaipei.model.Attraction
import com.maxma.funtaipei.model.News
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface APIService {

    data class GetAttractionsResponse(
        val total: Int,
        val data: List<Attraction>
    )

    data class GetNewsResponse(
        val total: Int,
        val data: List<News>
    )

    @Headers("Accept: application/json")
    @GET("{lang}/Attractions/All")
    suspend fun getAttractions(
        @Path("lang") lang: String,
        @Query("categoryIds") categoryIds: String,
        @Query("page") page: Int
    ): Response<GetAttractionsResponse>

    @Headers("Accept: application/json")
    @GET("{lang}/Events/News")
    fun getNews(
        @Path("lang") lang: String,
        @Query("page") page: Int
    ): Observable<GetNewsResponse>
}