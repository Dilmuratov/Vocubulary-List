package com.example.vocabularylist.domain.usecases.addterm

import com.example.vocabularylist.data.models.TextData
import com.example.vocabularylist.domain.MainRepository

class AddTextUseCaseImpl(private val mainRepository: MainRepository) : AddTextUseCase {
    override suspend fun execute(textData: TextData) = mainRepository.addText(textData)
}