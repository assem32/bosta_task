package com.example.bostatask.feature.domain.repo

import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.model.CityModel

interface ICitiesRepo {

    suspend fun getCities(countryId:String):ResponseState<CityModel>
}