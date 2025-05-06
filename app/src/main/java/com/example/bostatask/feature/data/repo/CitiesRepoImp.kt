package com.example.bostatask.feature.data.repo

import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.dataSource.remote.ICitiesRemoteDataSource
import com.example.bostatask.feature.data.model.CityModel
import com.example.bostatask.feature.domain.repo.ICitiesRepo
import javax.inject.Inject

class CitiesRepoImp @Inject constructor(private val iCitiesRemoteDataSource: ICitiesRemoteDataSource): ICitiesRepo{
    override suspend fun getCities(countryId:String): ResponseState<CityModel> {
        val response = iCitiesRemoteDataSource.getCities(countryId)
        return when (response){
            is ResponseState.Success -> ResponseState.Success(response.data)
            is ResponseState.Error ->
                ResponseState.Error(response.message)
            else -> ResponseState.Loading
        }
    }
}