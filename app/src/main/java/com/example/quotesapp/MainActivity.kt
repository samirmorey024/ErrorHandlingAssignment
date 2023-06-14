package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.quotesapp.presentation.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by viewModels<MainViewmodel>()
        val submitButton = findViewById<Button>(R.id.submit_button)
        val textView = findViewById<TextView>(R.id.text_view)

        viewModel.quotesLiveData.observe(this) {
            textView.text = it.body()?.results?.get(0)?.content
        }

        submitButton.setOnClickListener {
            viewModel.requestQuotes()
        }


    }
}