package com.example.placemark.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.placemark.activities.models.PlacemarkModel
import com.example.placemark.databinding.ActivityPlacemarkBinding
import com.github.ajalt.timberkt.Timber
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber.i
class PlacemarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacemarkBinding
    var placemark = PlacemarkModel()
    val placemarks = ArrayList<PlacemarkModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Timber.plant(Timber.DebugTree())
        i("Placemarks Activity started..")

        binding.btnAdd.setOnClickListener() {

            placemark.title =binding.placemarkTitle.text.toString()
            placemark.description =binding.placemarkDescription.text.toString()
            val pm = placemarks.add(placemark)
            if ( placemark.title.isNotEmpty() && placemark.description.isNotEmpty()) {
                i("add Button Pressed: ${placemark.title}, ${placemark.description}")
                i("add Button Pressed: $placemarks")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title and description", Snackbar.LENGTH_LONG)
                    .show()
            }
        }

    }
}