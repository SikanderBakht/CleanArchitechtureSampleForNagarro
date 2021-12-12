package com.sikander.nagarrocleanarchassignment.application.module

import com.sikander.data.articles.datasource.ProductsPagingSourceByCoroutine
import com.sikander.data.articles.repository.ProductsListRepositoryImpl
import com.sikander.domain.articles.repository.ArticlesListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun productsList(
        pagingSourceByCoroutine: ProductsPagingSourceByCoroutine
    ): ArticlesListRepository =
        ProductsListRepositoryImpl(pagingSourceByCoroutine)

}