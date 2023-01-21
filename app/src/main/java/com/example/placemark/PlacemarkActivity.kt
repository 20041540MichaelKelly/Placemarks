package com.example.placemark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.ajalt.timberkt.Timber
import timber.log.Timber.i
class PlacemarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)

        Timber.plant(Timber.DebugTree())
        i("Placemarks Activity started..")

    }
}