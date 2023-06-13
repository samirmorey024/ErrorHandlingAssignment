package com.example.quotesapp.data

data class Result(
    val _id: String,
    val author: String,
    val authorSlung: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)