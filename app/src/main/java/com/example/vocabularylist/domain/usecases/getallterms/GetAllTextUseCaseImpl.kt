package com.example.vocabularylist.domain.usecases.getallterms

import com.example.vocabularylist.domain.MainRepository

class GetAllTextUseCaseImpl(private val mainRepository: MainRepository) : GetAllTextUseCase {
    override suspend fun execute() = mainRepository.getAllText()
}