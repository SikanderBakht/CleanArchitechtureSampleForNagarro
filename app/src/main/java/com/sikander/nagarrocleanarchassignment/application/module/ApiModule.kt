package com.sikander.nagarrocleanarchassignment.application.module

import com.sikander.data.articles.remote.ProductsApi
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
    fun products(retrofit: Retrofit): ProductsApi =
        retrofit.create(ProductsApi::class.java)

}