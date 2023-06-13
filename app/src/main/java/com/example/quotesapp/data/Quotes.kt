package com.example.quotesapp.data

data class Quotes(
    val count: Int,
    val lastItemItem: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)