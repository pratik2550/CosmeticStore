package com.example.cosmeticstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.cosmeticstore.databinding.NewArrivalBinding

class NewArrivalAdapter(val newArrivalList: List<String>): RecyclerView.Adapter<NewArrivalAdapter.NewArrivalHolder>() {

    class NewArrivalHolder(val newArrivalBinding: NewArrivalBinding):
        RecyclerView.ViewHolder(newArrivalBinding.root){
        private var  binding:NewArrivalBinding? = null
        init {
            this.binding = newArrivalBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewArrivalHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NewArrivalBinding.inflate(layoutInflater, parent, false)
        return NewArrivalHolder(binding)
    }

    override fun onBindViewHolder(holder: NewArrivalHolder, position: Int) {
        holder.newArrivalBinding.NewArrivalTV.text = newArrivalList[position]
    }

    override fun getItemCount(): Int {
        return newArrivalList.size
    }
}