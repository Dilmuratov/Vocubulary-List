package com.example.vocabularylist.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text")
data class TextData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var text1: String,
    var text2: String
)
