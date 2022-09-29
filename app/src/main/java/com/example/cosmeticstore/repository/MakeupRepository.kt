package com.example.cosmeticstore.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cosmeticstore.data.MakeupItem
import com.example.cosmeticstore.data.makeup
import com.example.cosmeticstore.di.NetworkModule
import com.example.cosmeticstore.retrofit.MakeupApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class MakeupRepository @Inject constructor(private val makeupApi: MakeupApi) {

    private val _products = MutableLiveData<List<MakeupItem>>()
    val products: LiveData<List<MakeupItem>>
    get() = _products

    suspend fun getCosmetic() {
        val result = makeupApi.getCosmeticsList()
        if (result.isSuccessful && result.body()!=null) {
            _products.postValue(result.body())
        }
    }

    suspend fun getCosmeticByBrand(brandName: String) {
        val result = makeupApi.getCosmeticsByBrand(brandName)
        if (result.isSuccessful && result.body()!=null) {
            _products.postValue(result.body())
        }
    }


}