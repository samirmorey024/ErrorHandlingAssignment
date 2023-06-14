package com.example.quotesapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("/quotes")
   suspend fun getQuotes(@Query("page") page: Int): Response<Quotes>
}