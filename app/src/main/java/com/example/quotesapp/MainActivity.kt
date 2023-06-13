package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.Quotes
import com.example.quotesapp.data.QuotesApi
import com.example.quotesapp.data.RetrofitHelper
import com.example.quotesapp.presentation.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by viewModels<MainViewmodel>()
        val submitButton = findViewById<Button>(R.id.submit_button)
        val textView = findViewById<TextView>(R.id.text_view)

        viewModel.quotesLiveData.observe(this) {
            Log.d("####","result"+it.body())
            textView.text = it.body()?.results?.get(0)?.content
        }

        submitButton.setOnClickListener {
            viewModel.requestQuotes()
        }


    }
}