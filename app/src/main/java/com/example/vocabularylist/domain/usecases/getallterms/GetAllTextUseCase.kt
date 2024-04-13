package com.example.vocabularylist.domain.usecases.getallterms

import com.example.vocabularylist.data.models.TextData
import kotlinx.coroutines.flow.Flow

interface GetAllTextUseCase {
    suspend fun execute(): Flow<List<TextData>>
}