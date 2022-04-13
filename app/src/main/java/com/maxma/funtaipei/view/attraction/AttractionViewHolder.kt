package com.maxma.funtaipei.view.attraction

import androidx.recyclerview.widget.RecyclerView
import com.maxma.funtaipei.databinding.AttractionRecyclerItemBinding
import com.maxma.funtaipei.model.Attraction

class AttractionViewHolder(itemBinding: AttractionRecyclerItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    private var viewBinding: AttractionRecyclerItemBinding = itemBinding

    fun bind(attraction: Attraction) {
        viewBinding.attraction = attraction
    }
}