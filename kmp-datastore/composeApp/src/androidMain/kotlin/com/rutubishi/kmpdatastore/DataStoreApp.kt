package com.rutubishi.kmpdatastore

import DataStoreAppComponent
import android.app.Application

class DataStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreAppComponent.init(context = applicationContext)
    }
}