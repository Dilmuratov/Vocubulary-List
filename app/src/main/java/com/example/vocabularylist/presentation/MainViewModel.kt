package com.example.vocabularylist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vocabularylist.data.models.TextData

abstract class MainViewModel : ViewModel() {

    abstract val allTextLiveData: LiveData<List<TextData>>
    abstract suspend fun getAllTerms()

    abstract suspend fun addText(textData: TextData)
}