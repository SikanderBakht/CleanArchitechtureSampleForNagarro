package com.sikander.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.sikander.domain.articles.usecase.GetArticlesListParams
import com.sikander.domain.articles.usecase.GetArticlesListUseCase
import com.sikander.presentation.base.RecyclerItem
import com.sikander.presentation.entity.ArticleMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticlesListUseCase: GetArticlesListUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _articlesListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val articlesListByCoroutine: Flow<PagingData<RecyclerItem>> = _articlesListByCoroutine

    init {
        getArticles("")
    }

    private fun getArticlesList(ids: String) =
        getArticlesListUseCase(GetArticlesListParams(ids = ids))
            .cachedIn(viewModelScope      )
    /*.cachedIn(viewModelScope)*/

    private fun getArticles(ids: String) {
        viewModelScope.launch {
            _articlesListByCoroutine.value = getArticlesList(ids).first()
                .map { article ->
                    ArticleMapper().mapLeftToRight(article)
                }
        }
    }
}