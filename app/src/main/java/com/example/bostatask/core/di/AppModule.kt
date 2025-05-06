package com.example.bostatask.core.di

import com.example.bostatask.core.network.ApiCalls
import com.example.bostatask.core.utils.BASEURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Provides
    @Singleton
    fun getApiCalls(retrofit: Retrofit):ApiCalls{
        return retrofit.create(ApiCalls::class.java)
    }

}