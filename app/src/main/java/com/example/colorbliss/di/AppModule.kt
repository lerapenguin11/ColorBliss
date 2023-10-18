package com.example.colorbliss.di

import com.example.colorbliss.viewmodel.PicViewModel
import com.example.colorbliss.viewmodel.SettingsViewModel
import com.example.domain.usecase.GetPictureUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PicViewModel> {
        PicViewModel(
            pictureUseCase = GetPictureUseCase(get())
        )
    }

    viewModel<SettingsViewModel> {
        val appContext = androidContext().applicationContext

        SettingsViewModel(
            application = get()
        )
    }
}