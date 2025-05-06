package com.example.bostatask.feature.domain.useCase

import com.example.bostatask.core.network.ResponseState
import com.example.bostatask.feature.data.model.CityModel
import com.example.bostatask.feature.domain.repo.ICitiesRepo
import javax.inject.Inject

class getCitiesUseCase  @Inject constructor(private val repo: ICitiesRepo) {
    suspend fun invoke(countryId:String):ResponseState<CityModel>{
        return repo.getCities(countryId)
    }
}