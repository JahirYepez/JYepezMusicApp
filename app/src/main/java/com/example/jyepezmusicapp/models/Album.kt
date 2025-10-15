package com.example.jyepezmusicapp.models

data class Album(
    val title : String,
    val artist : String,
    val description : String? = null,
    val image: String,
    val id : String
)
