package com.example.colorbliss.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colorbliss.Constants
import com.example.domain.entities.Picture
import com.example.domain.usecase.GetPictureUseCase
import kotlinx.coroutines.launch

class PicViewModel(
    private val pictureUseCase: GetPictureUseCase
) : ViewModel() {

    fun getResultPic(): MutableList<Picture> {
        var mutableData = mutableListOf<Picture>()
        viewModelScope.launch{
            mutableData = pictureUseCase.invoke(Constants.getPicData())
        }

        return mutableData
    }
}