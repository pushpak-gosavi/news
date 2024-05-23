package com.pushpak.newssdk.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pushpak.newssdk.screen.NewsList.NewsListScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NewsListScreen.route
    ){
        composable(
            route = Screen.NewsListScreen.route
        ){
            NewsListScreen()
        }
    }

}