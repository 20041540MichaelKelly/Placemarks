package com.example.placemark.activities.main

import android.app.Application
import com.example.placemark.activities.models.PlacemarkMemStore
import com.example.placemark.activities.models.PlacemarkModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {
    val placemarks = PlacemarkMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Placemark started")
    }
}