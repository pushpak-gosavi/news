package com.pushpak.newssdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pushpak.mynews.api.NewsAPI
import com.pushpak.mynews.api.RetrofitHelper
import com.pushpak.mynews.repository.NewsRepository
import com.pushpak.newssdk.nav.Screen
import com.pushpak.newssdk.nav.SetupNavGraph
import com.pushpak.newssdk.screen.NewsList.NewsListScreen
import com.pushpak.newssdk.ui.theme.NewsSDKTheme
import com.pushpak.newssdk.viewmodels.MainViewModel
import com.pushpak.newssdk.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var navController: NavHostController
        setContent {
            NewsSDKTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //NewsListScreen()
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
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