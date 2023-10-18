package com.example.colorbliss.di

import com.example.domain.usecase.GetPictureUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetPictureUseCase> { GetPictureUseCase(
        repository = get()
    ) }
}