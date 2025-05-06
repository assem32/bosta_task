package com.example.bostatask.core.network

import com.example.bostatask.feature.data.model.CityModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("cities/getAllDistricts")
    suspend fun getCities(@Query("countryId") countryId: String):CityModel
}