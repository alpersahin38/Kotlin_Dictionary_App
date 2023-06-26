package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.lang.Exception

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var wordsList: ArrayList<Words>
    private lateinit var adapter: WordsAdapter
    private lateinit var vt: HelperDatabase

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        CopyDatabase()
        binding.toolbar.title = "Dictionary App"
        binding.toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(binding.toolbar)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        vt = HelperDatabase(this)
        wordsList = Wordsdao().allWords(vt)

        adapter = WordsAdapter(this, wordsList)

        binding.rv.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        Search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Search(newText)
        return true
    }

    fun CopyDatabase() {
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun Search(searchWords: String){
        wordsList = Wordsdao().allWords(vt)

        adapter = WordsAdapter(this, wordsList)

        binding.rv.adapter = adapter
    }
}