package com.example.carofflinecache.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carofflinecache.R
import com.example.carofflinecache.adapter.CarAdapter
import com.example.carofflinecache.databinding.ActivityCarBinding
import com.example.carofflinecache.util.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CarActivity : AppCompatActivity() {

    // Helps to preserve the view
    // If the app is closed, then after
    // reopening it the app will open
    // in a state in which it was closed

    // DaggerHilt will inject the view-model for us
    private val viewModel: CarListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The bellow segment would
        // instantiate the activity_car layout
        // and will create a property for different
        // views inside it!
        val binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carAdapter = CarAdapter()

        binding.apply {
            recyclerViewer.apply {
                adapter = carAdapter
                layoutManager = LinearLayoutManager(this@CarActivity)
            }

            viewModel.cars.observe(this@CarActivity) { result ->
                carAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading<*> && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error<*> && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }
        }
    }
}

//class CarActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_car)
//    }
//}
