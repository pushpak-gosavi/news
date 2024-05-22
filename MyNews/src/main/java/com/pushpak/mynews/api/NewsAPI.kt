package com.pushpak.mynews.api

import com.pushpak.mynews.models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("top-headlines/sources")
    suspend fun getHeadlines(@Query("apiKey") apiKey:String) : Response<NewsData>
}