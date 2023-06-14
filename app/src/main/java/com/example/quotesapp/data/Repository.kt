package com.example.quotesapp.data


import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor ( private val quotesApi: QuotesApi) {

    private val _quotesLiveData = MutableLiveData<Response<Quotes>>()

    val quotesLiveData = _quotesLiveData
    suspend fun fetchQuotes() {
        val result = quotesApi.getQuotes(1)
        _quotesLiveData.postValue(result)
    }
}