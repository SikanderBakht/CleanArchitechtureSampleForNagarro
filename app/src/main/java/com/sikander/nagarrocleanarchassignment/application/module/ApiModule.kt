package com.sikander.nagarrocleanarchassignment.application.module

import com.sikander.data.articles.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    @Singleton
    fun products(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}