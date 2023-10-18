package com.example.data.repository

import com.example.domain.entities.Picture
import com.example.domain.repository.PicRepository

class PaintingsRepositoryImpl(
    private val dataSource: PaintingsDataSource
) : PicRepository {
    override fun getPic(picture: MutableList<Picture>): MutableList<Picture> {
        return dataSource.getPic(picture)
    }
}