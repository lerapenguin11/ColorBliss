package com.example.colorbliss.di

import com.example.data.repository.PaintingsDataSource
import com.example.data.repository.PaintingsDataSourceImpl
import com.example.data.repository.PaintingsRepositoryImpl
import com.example.domain.repository.PicRepository
import org.koin.dsl.module

val dataModule = module {
    single<PaintingsDataSource> { PaintingsDataSourceImpl() }
    single<PicRepository> { PaintingsRepositoryImpl(get()) }
}