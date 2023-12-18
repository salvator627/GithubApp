package com.example.githubsearchapp.Data.Model

data class DetailResponse (
    val login : String,
    val id : Int,
    val avatar_url : String,
    val followers_url : String,
    val following_url : String,
    val followers : Int,
    val following : Int
)