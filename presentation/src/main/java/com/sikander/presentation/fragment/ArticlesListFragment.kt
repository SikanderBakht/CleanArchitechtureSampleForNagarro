package com.sikander.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.sikander.domain.base.Failure
import com.sikander.presentation.R
import com.sikander.presentation.adapter.ArticleListAdapter
import com.sikander.presentation.adapter.LoadingStateAdapter
import com.sikander.presentation.base.RecyclerItem
import com.sikander.presentation.databinding.FragmentArticlesListBinding
import com.sikander.presentation.extension.collectIn
import com.sikander.presentation.extension.gone
import com.sikander.presentation.extension.viewBinding
import com.sikander.presentation.extension.visible
import com.sikander.presentation.viewmodel.ArticleListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesListFragment : Fragment(R.layout.fragment_articles_list) {
    private val binding by viewBinding(FragmentArticlesListBinding::bind) {
        cleanUp(it)
    }

    private val articleListViewModel: ArticleListViewModel by viewModels()

    private val articleListAdapter: ArticleListAdapter by lazy {
        ArticleListAdapter(::showToast)
        //ArticleListAdapter(::navigateToProductDetail)
    }

    private fun showToast(item: RecyclerItem, view: View) {
        activity?.let {
            if(isAdded) {
                Toast.makeText(it, "item Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewByCoroutine()
        setupRecycler()
    }

    private fun setupViewByCoroutine() {
        articleListViewModel.run {
            articlesListByCoroutine.collectIn(viewLifecycleOwner) {
                addProductsList(it)
            }

            failure.collectIn(viewLifecycleOwner) {
                handleFailure(it)
            }
        }
    }

    private fun setupRecycler() {
        binding.tvError.gone()
        binding.rvArticles.adapter =
            articleListAdapter.withLoadStateFooter(LoadingStateAdapter())
        articleListAdapter.addLoadStateListener { adapterLoadingErrorHandling(it) }
        articleListAdapter.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        //productListRecyclerView.itemAnimator = null
        //postponeEnterTransition()
        //view?.doOnPreDraw { startPostponedEnterTransition() }
    }

    private fun adapterLoadingErrorHandling(combinedLoadStates: CombinedLoadStates) {
        if (combinedLoadStates.refresh is LoadState.Loading) {
            loadingUI(true)
        } else {
            loadingUI(false)
            val error = when {
                combinedLoadStates.prepend is LoadState.Error -> combinedLoadStates.prepend as LoadState.Error
                combinedLoadStates.source.prepend is LoadState.Error -> combinedLoadStates.prepend as LoadState.Error
                combinedLoadStates.append is LoadState.Error -> combinedLoadStates.append as LoadState.Error
                combinedLoadStates.source.append is LoadState.Error -> combinedLoadStates.append as LoadState.Error
                combinedLoadStates.refresh is LoadState.Error -> combinedLoadStates.refresh as LoadState.Error
                else -> null
            }
            error?.run {
                articleListViewModel.handleFailure(this.error) {

                }
            }
        }
    }

    private fun loadingUI(isLoading: Boolean) {
        binding.tvError.gone()
        if (isLoading) {
            binding.tvLoading.visible()
        } else {
            binding.tvLoading.gone()
            binding.rvArticles.visible()
        }
    }

    private fun addProductsList(productsList: PagingData<RecyclerItem>) {
        binding.rvArticles.visible()
        articleListAdapter.submitData(lifecycle, productsList)
    }

    // region helper methods
    private fun cleanUp(binding: FragmentArticlesListBinding?) {
        binding?.rvArticles?.adapter = null
    }
    // endregion

    private fun handleFailure(failure: Failure) {
        binding.rvArticles.gone()
        Toast.makeText(activity, "API Error", Toast.LENGTH_SHORT).show()
        binding.tvError.visible()
    }
}