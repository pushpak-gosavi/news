package com.pushpak.mynews.models


import com.google.gson.annotations.SerializedName

data class Source(
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)