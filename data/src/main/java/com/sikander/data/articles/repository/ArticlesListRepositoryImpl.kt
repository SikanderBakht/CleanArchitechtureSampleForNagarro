package com.sikander.data.articles.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sikander.data.articles.datasource.ProductsPagingSourceByCoroutine
import com.sikander.domain.articles.entity.Article
import com.sikander.domain.articles.repository.ArticlesListRepository
import com.sikander.domain.extensions.allowReads
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesListRepositoryImpl @Inject constructor(

    private val pagingSourceByCoroutine: ProductsPagingSourceByCoroutine
) : ArticlesListRepository {
    override fun getArticlesList(ids: String): Flow<PagingData<Article>> =
        allowReads {
            Pager(
                config = PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false,
                    maxSize = 30,
                    prefetchDistance = 5,
                    initialLoadSize = 10,
                    jumpThreshold = 60
                ),
                pagingSourceFactory = { pagingSourceByCoroutine }
            ).flow
        }
}