package com.example.cosmeticstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cosmeticstore.databinding.QuickCategoriesBinding

class QuickCategoryAdapter(private val itemList: List<String>): RecyclerView.Adapter<QuickCategoryAdapter.QuickCategoryHolder>() {

    class QuickCategoryHolder(val quickCategoriesBinding: QuickCategoriesBinding):
            RecyclerView.ViewHolder(quickCategoriesBinding.root) {
                private var binding: QuickCategoriesBinding? = null
                init {
                    this.binding = quickCategoriesBinding
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickCategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuickCategoriesBinding.inflate(inflater, parent, false)
        return QuickCategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: QuickCategoryHolder, position: Int) {
        holder.quickCategoriesBinding.quickCategoryTV.text = itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}