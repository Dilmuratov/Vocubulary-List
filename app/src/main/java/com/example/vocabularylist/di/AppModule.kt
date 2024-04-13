package com.example.vocabularylist.di

import com.example.vocabularylist.presentation.MainViewModel
import com.example.vocabularylist.presentation.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModelImpl(
            getAllTextUseCase = get(),
            addTextUseCase = get()
        )
    }
}