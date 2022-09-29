package com.example.cosmeticstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cosmeticstore.databinding.SlidingImageBinding

class ViewPagerAdapter(val imageList: List<Int>):
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    class ViewPagerHolder(val slidingImageBinding: SlidingImageBinding) :
        RecyclerView.ViewHolder(slidingImageBinding.root) {
        private var binding : SlidingImageBinding? = null
        init {
            this.binding = slidingImageBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SlidingImageBinding.inflate(inflater, parent, false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.slidingImageBinding.idIVImage.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}