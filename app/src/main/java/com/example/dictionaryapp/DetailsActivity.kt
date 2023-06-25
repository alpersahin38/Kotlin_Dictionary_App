package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionaryapp.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val word = intent.getSerializableExtra("object") as Words

        binding.textViewDetailsEnglish.text = word.turkish
        binding.textViewDetailsTurkish.text = word.english
    }
}