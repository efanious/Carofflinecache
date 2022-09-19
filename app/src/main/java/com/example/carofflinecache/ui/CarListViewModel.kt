package com.example.carofflinecache.ui

import androidx.lifecycle.ViewModel
import com.example.carofflinecache.repositories.CarListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.asLiveData

@HiltViewModel
class CarListViewModel @Inject constructor(
    repository: CarListRepository
) : ViewModel() {
    val cars = repository.getCars().asLiveData()
}