package com.sikander.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.sikander.data.articles.remote.SampleUseCase
import com.sikander.domain.articles.usecase.GetArticlesListParams
import com.sikander.domain.articles.usecase.GetArticlesListUseCase
import com.sikander.presentation.State
import com.sikander.presentation.base.RecyclerItem
import com.sikander.presentation.entity.ArticleMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticlesListUseCase: GetArticlesListUseCase,
    private val sampleUseCase: SampleUseCase,
) : BaseViewModel() {

    private val _articlesListByCoroutine =
        MutableStateFlow<PagingData<RecyclerItem>>(PagingData.empty())
    val articlesListByCoroutine: Flow<PagingData<RecyclerItem>> = _articlesListByCoroutine

    init {
        getArticles("")
    }

    private fun getArticlesList(ids: String) =
        getArticlesListUseCase(GetArticlesListParams(ids = ids))
    /*.cachedIn(viewModelScope)*/

    private fun getArticles(ids: String) {
        viewModelScope.launch {
            _articlesListByCoroutine.value = getArticlesList(ids).first()
                .map { article ->
                    ArticleMapper().mapLeftToRight(article)
                }
        }
    }

    fun getSampleResponse() = flow {
        emit(State.LoadingState)
        try {
            delay(1000)
            emit(State.DataState(sampleUseCase()))
        } catch (e: Exception) {
            e.printStackTrace()
            //emit(Utils.resolveError(e))
        }
    }
}