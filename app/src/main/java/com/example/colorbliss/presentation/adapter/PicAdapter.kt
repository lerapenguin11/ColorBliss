package com.example.colorbliss.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.colorbliss.R
import com.example.domain.entities.Picture

class PicAdapter() : RecyclerView.Adapter<PicAdapter.PicViewHolder>() {
    private val picList = mutableListOf<Picture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pic, parent, false)

        return PicViewHolder(view)
    }

    override fun getItemCount(): Int = picList.size

    override fun onBindViewHolder(holder: PicViewHolder, position: Int) {
        val pic : Picture = picList[position]
        holder.icon.setImageResource(pic.picture)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<Picture>){
        picList.clear()
        picList.addAll(list)
        notifyDataSetChanged()
    }

    class PicViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val icon : ImageView = view.findViewById(R.id.ic_pic)
    }
}