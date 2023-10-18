package com.example.data.repository

import com.example.domain.entities.Picture

interface PaintingsDataSource {

    fun getPic(picture : MutableList<Picture>) : MutableList<Picture>
}