package com.example.dictionaryapp

class Wordsdao {

    fun allWords(vt:HelperDatabase) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler", null)

        while (c.moveToNext()){
            val word = Words(c.getInt(c.getColumnIndex("kelime_id"))
                ,c.getString(c.getColumnIndex("inglizce"))
                , c.getString(c.getColumnIndex("turkce")))
            wordsList.add(word)
        }

        return wordsList
    }

    fun DoSearch(vt:HelperDatabase, searchWord: String) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$searchWord'", null)

        while (c.moveToNext()){
            val word = Words(c.getInt(c.getColumnIndex("kelime_id"))
                ,c.getString(c.getColumnIndex("inglizce"))
                , c.getString(c.getColumnIndex("turkce")))
            wordsList.add(word)
        }

        return wordsList
    }
}