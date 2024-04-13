package com.example.vocabularylist.domain.usecases.addterm

import com.example.vocabularylist.data.models.TextData

interface AddTextUseCase {
    suspend fun execute(termData: TextData)
}