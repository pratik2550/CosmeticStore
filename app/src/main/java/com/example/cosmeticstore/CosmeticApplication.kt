package com.example.cosmeticstore

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CosmeticApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}