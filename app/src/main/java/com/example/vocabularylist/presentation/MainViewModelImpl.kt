package com.example.vocabularylist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.vocabularylist.domain.usecases.addterm.AddTextUseCase
import com.example.vocabularylist.domain.usecases.getallterms.GetAllTextUseCase
import com.example.vocabularylist.data.models.TextData

class MainViewModelImpl(
    private val getAllTextUseCase: GetAllTextUseCase,
    private val addTextUseCase: AddTextUseCase,
) : MainViewModel() {

    override val allTextLiveData: LiveData<List<TextData>>
        get() = _allTextLiveData
    private val _allTextLiveData = MutableLiveData<List<TextData>>()

    override suspend fun getAllTerms() {
        getAllTextUseCase.execute().collect {
            _allTextLiveData.value = it
        }
    }

    override suspend fun addText(textData: TextData) = addTextUseCase.execute(textData)
}