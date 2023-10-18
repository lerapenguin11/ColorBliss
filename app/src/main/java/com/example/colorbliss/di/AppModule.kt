package com.example.colorbliss.di

import com.example.colorbliss.viewmodel.PicViewModel
import com.example.domain.usecase.GetPictureUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PicViewModel> {
        PicViewModel(
            pictureUseCase = GetPictureUseCase(get())
        )
    }
}