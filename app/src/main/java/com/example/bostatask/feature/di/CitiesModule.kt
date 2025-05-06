package com.example.bostatask.feature.di

import com.example.bostatask.core.network.ApiCalls
import com.example.bostatask.feature.data.dataSource.remote.CitiesRemoteDataSourceImp
import com.example.bostatask.feature.data.dataSource.remote.ICitiesRemoteDataSource
import com.example.bostatask.feature.data.repo.CitiesRepoImp
import com.example.bostatask.feature.domain.repo.ICitiesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CitiesModule {

    @Provides
    @Singleton
    fun getCitiesRepo(dataSourceImp: CitiesRemoteDataSourceImp):ICitiesRepo{
        return CitiesRepoImp(dataSourceImp)
    }


    @Provides
    @Singleton
    fun getRemoteDataSource(apiCalls: ApiCalls):ICitiesRemoteDataSource{
        return CitiesRemoteDataSourceImp(apiCalls)
    }
}