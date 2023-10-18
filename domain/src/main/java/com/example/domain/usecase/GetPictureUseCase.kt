package com.example.domain.usecase

import com.example.domain.entities.Picture
import com.example.domain.repository.PicRepository

class GetPictureUseCase(private val repository: PicRepository) {

    operator fun invoke(picture: MutableList<Picture>) = repository.getPic(picture)
}