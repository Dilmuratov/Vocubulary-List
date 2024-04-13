package com.example.vocabularylist.data.repository

import com.example.vocabularylist.domain.MainRepository
import com.example.vocabularylist.data.local.MainDao
import com.example.vocabularylist.data.models.TextData
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val dao: MainDao) : MainRepository {

    override suspend fun getAllText() = flow {
        emit(dao.getAllText())
    }

    override suspend fun addText(textData: TextData) = dao.addText(textData)

}