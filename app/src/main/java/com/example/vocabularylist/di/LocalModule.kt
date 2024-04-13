package com.example.vocabularylist.di

import com.example.vocabularylist.data.local.MainDao
import com.example.vocabularylist.data.local.MainDataBase
import org.koin.dsl.module

val localModule = module {
    single<MainDao> {
        get<MainDataBase>().getDao()
    }
}