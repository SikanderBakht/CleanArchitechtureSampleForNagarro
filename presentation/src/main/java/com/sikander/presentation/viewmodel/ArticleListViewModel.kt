package com.sikander.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticlesListUseCase: GetArticlesListUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _productsListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val productsListByCoroutine: Flow<PagingData<RecyclerItem>> = _productsListByCoroutine

    init {
        getProductsBaseOnPath("")
    }

    private fun getArticlesList(ids: String) =
        getArticlesListUseCase(GetArticlesListParams(ids = ids))
    /*.cachedIn(viewModelScope)*/

    private fun getProductsBaseOnPath(ids: String) {
        viewModelScope.launch {
            _productsListByCoroutine.value = getArticlesList(ids).first()
                .map { article ->
                    ArticleMapper().mapLeftToRight(article)
                }
        }
    }
}