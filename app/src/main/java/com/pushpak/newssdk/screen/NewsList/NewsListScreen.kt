package com.pushpak.newssdk.screen.NewsList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pushpak.mynews.api.NewsAPI
import com.pushpak.mynews.api.RetrofitHelper
import com.pushpak.mynews.repository.NewsRepository
import com.pushpak.newssdk.nav.Screen
import com.pushpak.newssdk.viewmodels.MainViewModel
import com.pushpak.newssdk.viewmodels.MainViewModelFactory

@Composable
fun NewsListScreen() {
    lateinit var mainViewModel:MainViewModel
    val newsHeadline = RetrofitHelper.getInstance().create(NewsAPI::class.java)
    val repository = NewsRepository(newsHeadline)
    mainViewModel = viewModel(factory = MainViewModelFactory(repository))
    val headLines by mainViewModel.headLines.observeAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            headLines?.sources?.let {
                items(count = it.size) { headLine ->
                    NewsCard(data = headLines!!.sources[headLine])
                }
            }

        }

    )
}