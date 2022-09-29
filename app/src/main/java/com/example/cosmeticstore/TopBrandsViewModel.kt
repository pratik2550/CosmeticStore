package com.example.cosmeticstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cosmeticstore.databinding.TopBrandsBinding

class TopBrandsAdapter(val topBrandList: List<String>): RecyclerView.Adapter<TopBrandsAdapter.TopBrandsHolder>() {

    class TopBrandsHolder(val topBrandsBinding: TopBrandsBinding):
            RecyclerView.ViewHolder(topBrandsBinding.root) {
                private var binding: TopBrandsBinding? = null
                init {
                    this.binding = topBrandsBinding
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopBrandsHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val binding = TopBrandsBinding.inflate(layoutInflater, parent, false)
        return TopBrandsHolder(binding)
    }

    override fun onBindViewHolder(holder: TopBrandsHolder, position: Int) {
        holder.topBrandsBinding.brandNameTV.text = topBrandList[position]
    }

    override fun getItemCount(): Int {
        return topBrandList.size
    }
}