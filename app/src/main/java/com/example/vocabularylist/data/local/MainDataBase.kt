package com.example.vocabularylist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vocabularylist.data.models.TextData

@Database(entities = [TextData::class], version = 1)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getDao(): MainDao
}