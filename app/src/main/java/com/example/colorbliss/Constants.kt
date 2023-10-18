package com.example.colorbliss

import com.example.domain.entities.Picture

object Constants {

    fun getPicData() : MutableList<Picture>{
        var picList = mutableListOf<Picture>()

        val pic1 = Picture(0, R.drawable.ic1)
        picList.add(pic1)

        val pic2 = Picture(1, R.drawable.ic2)
        picList.add(pic2)

        val pic3 = Picture(2, R.drawable.ic3)
        picList.add(pic3)

        val pic4 = Picture(3, R.drawable.ic4)
        picList.add(pic4)

        val pic5 = Picture(4, R.drawable.ic5)
        picList.add(pic5)

        val pic6 = Picture(5, R.drawable.ic6)
        picList.add(pic6)

        val pic7 = Picture(6, R.drawable.ic7)
        picList.add(pic7)

        val pic8 = Picture(7, R.drawable.ic8)
        picList.add(pic8)

        val pic9 = Picture(8, R.drawable.ic9)
        picList.add(pic9)

        val pic10 = Picture(9, R.drawable.ic10)
        picList.add(pic10)

        return picList
    }
}