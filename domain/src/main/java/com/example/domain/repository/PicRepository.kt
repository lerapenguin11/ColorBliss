package com.example.domain.repository

import com.example.domain.entities.Picture

interface PicRepository {

    fun getPic(picture : MutableList<Picture>) : MutableList<Picture>
}