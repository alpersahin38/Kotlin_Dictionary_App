package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionaryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var wordsList:ArrayList<Words>
    private lateinit var adapter: WordsAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.title = "Dictionary App"
        setSupportActionBar(binding.toolbar)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        wordsList = ArrayList()

        val w1 = Words(1,"Dog", "Köpek")
        val w2 = Words(1,"Dog", "Köpek")
        val w3 = Words(1,"Dog", "Köpek")

        wordsList.add(w1)
        wordsList.add(w2)
        wordsList.add(w3)

        adapter = WordsAdapter(this, wordsList)

        binding.rv.adapter = adapter

    }
}