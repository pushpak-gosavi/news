package com.pushpak.mynews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pushpak.mynews.api.NewsAPI
import com.pushpak.mynews.models.NewsData

class NewsRepository(
    private val newsApi: NewsAPI
) {
    private val newsLiveData = MutableLiveData<NewsData>()

    val headLines:LiveData<NewsData>
        get() = newsLiveData
    suspend fun getHeadlines(apiKey:String){
        val result = newsApi.getHeadlines(apiKey)
        if(result?.body() !=null){
            newsLiveData.postValue(result.body())
        }
    }
}