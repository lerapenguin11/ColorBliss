package com.example.data.repository

import com.example.domain.entities.Picture

class PaintingsDataSourceImpl : PaintingsDataSource {

    override fun getPic(picture: MutableList<Picture>): MutableList<Picture> {
        val list = mutableListOf<Picture>()

        for (i in picture){
            val id = i.id
            val icon = i.picture

            val listLetterModel = Picture(
                id = id,
                picture = icon)

            list.add(listLetterModel)
        }

        return list
    }
}