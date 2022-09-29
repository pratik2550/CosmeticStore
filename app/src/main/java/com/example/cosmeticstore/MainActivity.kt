package com.example.cosmeticstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cosmeticstore.databinding.ActivityMainBinding
import com.example.cosmeticstore.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var brandName = "maybelline"
    private lateinit var imageList: List<Int>
    private lateinit var categoryList: List<String>
    private lateinit var brandList: List<String>
    private lateinit var newArrivalList: List<String>

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this._binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList = ArrayList()
        imageList = imageList + R.drawable.avengers
        imageList = imageList + R.drawable.sky

        categoryList = ArrayList()
        categoryList = categoryList + "Makeup"
        categoryList = categoryList + "Skincare"
        categoryList = categoryList + "Haircare"
        categoryList = categoryList + "Bodycare"
        categoryList = categoryList + "Nail"

        brandList = ArrayList()
        brandList = brandList + "almay"
        brandList = brandList + "alva"
        brandList = brandList + "anna sui"
        brandList = brandList + "annabelle"
        brandList = brandList + "benefit"
        brandList = brandList + "boosh"
        brandList = brandList + "burt's bees"
        brandList = brandList + "butter london"
        brandList = brandList + "c'est moi"

        newArrivalList = ArrayList()
        newArrivalList = newArrivalList + "Makeup"
        newArrivalList = newArrivalList + "Skincare"
        newArrivalList = newArrivalList + "Haircare"
        newArrivalList = newArrivalList + "Bodycare"
        newArrivalList = newArrivalList + "Nail"

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val quickCategoryAdapter = QuickCategoryAdapter(categoryList)

        val fixLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        val fixGridLayoutManager = object : GridLayoutManager(this,2) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.topBrandRV.layoutManager = fixGridLayoutManager
        val topBrandsAdapter = TopBrandsAdapter(brandList)

        binding.newArrivalRV.layoutManager = fixLinearLayoutManager
        val newArrivalAdapter = NewArrivalAdapter(newArrivalList)

        binding.viewPager2.adapter = ViewPagerAdapter(imageList)
        binding.recyclerView.adapter = quickCategoryAdapter
        binding.topBrandRV.adapter = topBrandsAdapter
        binding.newArrivalRV.adapter = newArrivalAdapter


        mainViewModel.cosmeticByBrandName(brandName)
        mainViewModel.myResponse.observe(this) {
            Log.i("Pratik", it.size.toString())
            for (i in 0..10) {
                Log.i("Pratik", it[i].brand)
            }
        }

    }
}
