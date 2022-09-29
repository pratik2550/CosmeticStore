package com.example.cosmeticstore.viewmodel

import androidx.lifecycle.*
import com.example.cosmeticstore.data.MakeupItem
import com.example.cosmeticstore.repository.MakeupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MakeupRepository): ViewModel() {
    val myResponse: LiveData<List<MakeupItem>>
    get() = repository.products

    fun cosmeticByBrandName(bName: String) {
        viewModelScope.launch {
            repository.getCosmeticByBrand(bName)
        }
    }

//    init {
//        viewModelScope.launch {
//            repository.getCosmeticByBrand(brandName)
//        }
//    }

}
