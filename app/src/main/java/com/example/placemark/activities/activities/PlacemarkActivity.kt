package com.example.placemark.activities.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.example.placemark.R
import com.example.placemark.activities.main.MainApp
import com.example.placemark.activities.models.PlacemarkModel
import com.example.placemark.databinding.ActivityPlacemarkBinding
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber.i
class PlacemarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacemarkBinding
    var placemark = PlacemarkModel()
    lateinit var app: MainApp
    var edit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp
        if (intent.hasExtra("placemark_edit")) {
            placemark = intent.extras?.getParcelable("placemark_edit")!!
            binding.placemarkTitle.setText(placemark.title)
            binding.placemarkDescription.setText(placemark.description)
            edit = true
        }
        if(edit) {
            binding.btnAdd.text = getString(R.string.save_placemark)
        }
        binding.btnAdd.setOnClickListener() {
            placemark.title = binding.placemarkTitle.text.toString()
            placemark.description = binding.placemarkDescription.text.toString()
            if (placemark.title.isNotEmpty()) {
                if(edit) {
                    app.placemarks.update(placemark.copy())
                }else {
                    app.placemarks.create(placemark.copy())
                }
                setResult(RESULT_OK)
                finish()
            } else {
                Snackbar.make(it, getString(R.string.enter_title_error), Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.cancel_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
