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
    private lateinit var viewPagerList: List<Int>
    private lateinit var categoryList: List<String>
    private lateinit var brandList: List<Int>
    private lateinit var newArrivalList: List<String>

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this._binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList = ArrayList()
        imageList = imageList + R.drawable.blush_icon
        imageList = imageList + R.drawable.eyeliner_icon
        imageList = imageList + R.drawable.foundation_icon
        imageList = imageList + R.drawable.lip_liner_icon
        imageList = imageList + R.drawable.mascara_icon
        imageList = imageList + R.drawable.nail_polish_icon

        viewPagerList = ArrayList()
        viewPagerList = viewPagerList + R.drawable.nykaa_1
        viewPagerList = viewPagerList + R.drawable.nykaa_2
        viewPagerList = viewPagerList + R.drawable.nykaa_3
        viewPagerList = viewPagerList + R.drawable.nykaa_6
        viewPagerList = viewPagerList + R.drawable.nykaa_7

        categoryList = ArrayList()
        categoryList = categoryList + "Makeup"
        categoryList = categoryList + "Skincare"
        categoryList = categoryList + "Haircare"
        categoryList = categoryList + "Bodycare"
        categoryList = categoryList + "Nail"

        brandList = ArrayList()
        brandList = brandList + R.drawable.loreal
        brandList = brandList + R.drawable.maybelline
        brandList = brandList + R.drawable.nyx
        brandList = brandList + R.drawable.dior
        brandList = brandList + R.drawable.clinque
        brandList = brandList + R.drawable.colourpop

        newArrivalList = ArrayList()
        newArrivalList = newArrivalList + "Makeup"
        newArrivalList = newArrivalList + "Skincare"
        newArrivalList = newArrivalList + "Haircare"
        newArrivalList = newArrivalList + "Bodycare"
        newArrivalList = newArrivalList + "Nail"

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val quickCategoryAdapter = QuickCategoryAdapter(imageList)

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

        binding.viewPager2.adapter = ViewPagerAdapter(viewPagerList)
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
