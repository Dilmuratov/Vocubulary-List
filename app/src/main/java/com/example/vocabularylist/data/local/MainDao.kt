package com.example.vocabularylist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vocabularylist.data.models.TextData

@Dao
interface MainDao {

    @Query("SELECT * FROM text")
    suspend fun getAllText(): List<TextData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addText(termData: TextData)

}