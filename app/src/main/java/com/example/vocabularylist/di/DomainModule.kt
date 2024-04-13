package com.example.vocabularylist.di

import com.example.vocabularylist.domain.usecases.addterm.AddTextUseCase
import com.example.vocabularylist.domain.usecases.addterm.AddTextUseCaseImpl
import com.example.vocabularylist.domain.usecases.getallterms.GetAllTextUseCase
import com.example.vocabularylist.domain.usecases.getallterms.GetAllTextUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetAllTextUseCase> {
        GetAllTextUseCaseImpl(mainRepository = get())
    }
    single<AddTextUseCase> {
        AddTextUseCaseImpl(mainRepository = get())
    }
}