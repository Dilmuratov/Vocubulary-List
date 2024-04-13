package com.example.vocabularylist.domain

import com.example.vocabularylist.data.models.TextData
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getAllText(): Flow<List<TextData>>

    suspend fun addText(termData: TextData)
}