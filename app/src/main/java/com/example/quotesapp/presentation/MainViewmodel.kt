package com.example.quotesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.Quotes
import com.example.quotesapp.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _quotesLiveData :MutableLiveData<Response<Quotes>> = repository.quotesLiveData

    val quotesLiveData = _quotesLiveData

    fun requestQuotes() {
        viewModelScope.launch {
            repository.fetchQuotes()
        }
    }
}