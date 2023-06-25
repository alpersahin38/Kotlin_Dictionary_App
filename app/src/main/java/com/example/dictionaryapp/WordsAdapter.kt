package com.example.dictionaryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.databinding.CardDesignBinding

class WordsAdapter(private val mContext:Context, private val wordsList:List<Words>) : RecyclerView.Adapter<WordsAdapter.CardDesignHolder>() {
    private lateinit var binding: CardDesignBinding

    inner class CardDesignHolder(design: View) : RecyclerView.ViewHolder(design){
        var word_card : CardView
        var textViewEnglish:TextView
        var textViewTurkish: TextView

        init {
            word_card = design.findViewById(R.id.word_card)
            textViewEnglish = design.findViewById(R.id.textViewEnglish)
            textViewTurkish = design.findViewById(R.id.textViewTurkish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
       return wordsList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val word = wordsList.get(position)
        holder.textViewEnglish.text = word.english
        holder.textViewTurkish.text = word.turkish

        holder.word_card.setOnClickListener {

        }
    }
}