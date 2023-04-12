package com.prueba.apppp.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prueba.apppp.Models.Cat
import com.prueba.apppp.databinding.ItemBreedBinding

class CatsAdapter(private val items: List<Cat>) : RecyclerView.Adapter<CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view =  ItemBreedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}