package com.example.cosmeticstore.retrofit

import com.example.cosmeticstore.data.MakeupItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeupApi {
    @GET("products.json")
    suspend fun getCosmeticsList(): Response<List<MakeupItem>>

    @GET("products.json")
    suspend fun getCosmeticsByBrand(@Query("brand") brand:String): Response<List<MakeupItem>>
}