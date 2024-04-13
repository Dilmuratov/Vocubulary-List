package com.example.vocabularylist.di

import androidx.room.Room
import com.example.vocabularylist.data.local.MainDataBase
import com.example.vocabularylist.data.repository.MainRepositoryImpl
import com.example.vocabularylist.domain.MainRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<MainRepository> {
        MainRepositoryImpl(
            dao = get()
        )
    }

    single<MainDataBase> {
        Room.databaseBuilder(
            androidContext(),
            MainDataBase::class.java,
            "text.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}