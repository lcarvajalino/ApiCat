package com.prueba.apppp.views

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.prueba.apppp.Models.Cat
import com.prueba.apppp.R
import com.prueba.apppp.databinding.ItemBreedBinding

class CatViewHolder(private val binding: ItemBreedBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cat: Cat) {
        binding.tvName.text = cat.name
        binding.tvPais.text = cat.origin
        binding.tvAtributo.text = cat.intelligence.toString()
        val glide = Glide.with(binding.tvName)

        val progressDrawable = CircularProgressDrawable(binding.imgBreed.context).apply {
            strokeWidth = 10f
            centerRadius = 50f
            start()
        }

        glide.load("https://cdn2.thecatapi.com/images/${cat.imageUrl}.jpg")
            .apply(RequestOptions()
                .placeholder(progressDrawable)
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(SIZE_ORIGINAL))
            .into(binding.imgBreed)
    }
}