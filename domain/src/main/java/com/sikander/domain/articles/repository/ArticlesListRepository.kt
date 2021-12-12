package com.sikander.domain.articles.repository

import androidx.paging.PagingData
import com.sikander.domain.articles.entity.Article
import kotlinx.coroutines.flow.Flow


interface ArticlesListRepository {
    fun getArticlesList(ids: String): Flow<PagingData<Article>>
}