package com.pushpak.newssdk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.pushpak.mynews.Addition
import com.pushpak.mynews.addTwoNumber
import com.pushpak.mynews.api.NewsAPI
import com.pushpak.mynews.api.RetrofitHelper
import com.pushpak.mynews.repository.NewsRepository
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

        mainViewModel.headLines.observe(this) {
            Log.d("newsData", it.sources.toString())
        }
        setContent {
            NewsSDKTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var addition by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Addition of two number is $addition",
            modifier = modifier.padding(bottom = 20.dp)
        )
        Button(onClick = {
            addition = Addition(10, 20).addTwoNumber()
        }) {
            Text(text = "Call me")
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsSDKTheme {
        Greeting()
    }
}*/