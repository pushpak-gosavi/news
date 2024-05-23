package com.pushpak.newssdk.nav

sealed class Screen(val route:String) {
    data object NewsListScreen : Screen(route = "news_list_screen")
    data object NewsDetailScreen : Screen(route = "news_detail_screen")
}