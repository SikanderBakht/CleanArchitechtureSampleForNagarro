package com.sikander.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sikander.data.articles.entity.NewArticleResponse
import com.sikander.presentation.R
import com.sikander.presentation.databinding.ArticleItemBinding


class NewArticleListAdapter(var newArticlesList: List<NewArticleResponse>) :
    RecyclerView.Adapter<NewArticleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ArticleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newArticlesList[position]
        with(holder.binding) {
            tvArticleTitle.text = item.title
            tvArticleFirstLetter.text = item.title
            tvArticleDate.text = item.publishedDate
            tvArticleAuthor.text = item.byLine
        }
    }

    override fun getItemViewType(position: Int) = R.layout.article_item

    override fun getItemCount() = newArticlesList.size

    class ViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root)
}