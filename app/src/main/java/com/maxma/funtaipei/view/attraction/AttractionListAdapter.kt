package com.maxma.funtaipei.view.attraction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxma.funtaipei.databinding.AttractionRecyclerItemBinding
import com.maxma.funtaipei.model.Attraction

class AttractionListAdapter() : RecyclerView.Adapter<AttractionViewHolder>() {

    private var attractionList: MutableList<Attraction> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AttractionRecyclerItemBinding.inflate(inflater, parent, false)
        return AttractionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttractionViewHolder, position: Int) {
        holder.bind(attractionList.get(position))
    }

    override fun getItemCount(): Int {
        return attractionList.size
    }

    fun setData(attractions: List<Attraction>) {
        attractionList.clear()
        attractionList.addAll(attractions)
        notifyDataSetChanged()
    }
}