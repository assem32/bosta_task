package com.example.bostatask.feature.data.dataSource.remote

import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.model.CityModel

interface ICitiesRemoteDataSource {

    suspend fun getCities(countryId:String):ResponseState<CityModel>
}