package com.pushpak.newssdk

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.pushpak.mynews.Addition
import com.pushpak.mynews.addTwoNumber
import com.pushpak.mynews.api.NewsAPI
import com.pushpak.mynews.api.RetrofitHelper
import com.pushpak.mynews.models.NewsData
import com.pushpak.mynews.models.Source
import com.pushpak.mynews.repository.NewsRepository
import com.pushpak.newssdk.ui.NewsCard
import com.pushpak.newssdk.ui.theme.NewsSDKTheme
import com.pushpak.newssdk.viewmodels.MainViewModel
import com.pushpak.newssdk.viewmodels.MainViewModelFactory
import kotlin.math.log

class MainActivity : ComponentActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newsHeadline = RetrofitHelper.getInstance().create(NewsAPI::class.java)
        val repository = NewsRepository(newsHeadline)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository = repository)
        )[MainViewModel::class.java]
        setContent {
            NewsSDKTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeadLineList(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun HeadLineList(mainViewModel:MainViewModel) {
    val headLines by mainViewModel.headLines.observeAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            headLines?.sources?.let {
                items(count = it.size) { headLine ->
                    NewsCard(data = headLines!!.sources[headLine])
                }
            }

        }

    )
}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsSDKTheme {
        Greeting()
    }
}*/