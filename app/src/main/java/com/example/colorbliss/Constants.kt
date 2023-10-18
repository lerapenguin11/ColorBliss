package com.example.colorbliss

import com.example.domain.entities.Picture

object Constants {

    fun getPicData() : MutableList<Picture>{
        var picList = mutableListOf<Picture>()

        val pic1 = Picture(0, R.drawable.ic1)
        picList.add(pic1)

        return picList
    }
}