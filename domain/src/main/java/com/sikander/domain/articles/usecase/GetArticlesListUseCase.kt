package com.sikander.domain.articles.usecase

import androidx.paging.PagingData
import com.sikander.domain.articles.entity.Article
import com.sikander.domain.articles.repository.ArticlesListRepository
import com.sikander.domain.base.usecase.GeneralUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesListUseCase @Inject constructor(
    private val articlesListRepository: ArticlesListRepository,
) : GeneralUseCase<Flow<PagingData<Article>>, GetArticlesListParams> {

    override fun invoke(params: GetArticlesListParams): Flow<PagingData<Article>> =
        articlesListRepository.getArticlesList(params.ids)
}

@JvmInline
value class GetArticlesListParams(val ids: String)