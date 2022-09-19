package com.example.carofflinecache.data

import retrofit2.http.GET

interface CarListAPI {
    // Companion object to hold the base URL
    companion object{
        const val BASE_URL = "https://random-data-api.com/api/"
    }
    // The number of cars can be varied using the size.
    // By default it is kept at 20, but can be tweaked.
    // @GET annotation to make a GET request.
    @GET("vehicle/random_vehicle?size=20")
    // Store the data in a list.
    suspend fun getCarList() : List<CarList>
}