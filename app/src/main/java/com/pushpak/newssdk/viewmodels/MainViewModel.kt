package com.pushpak.newssdk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pushpak.mynews.models.NewsData
import com.pushpak.mynews.repository.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel(val newsRepository: NewsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            newsRepository.getHeadlines(apiKey = "300e401e143940bc91c1d344186b36ea")
        }
    }

    val headLines : LiveData<NewsData>
        get() = newsRepository.headLines
}