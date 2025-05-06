package com.example.bostatask.feature.data.dataSource.remote

import com.example.bostatask.core.network.ApiCalls
import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.model.CityModel
import javax.inject.Inject

class CitiesRemoteDataSourceImp @Inject constructor(private val  apiCalls: ApiCalls) : ICitiesRemoteDataSource {

    override suspend fun getCities (countryId:String): ResponseState<CityModel> {
        val response = apiCalls.getCities(countryId)
        if (response.success){
            return ResponseState.Success(response)
        }
        else {
            return ResponseState.Error(response.message)
        }

    }
}