package com.sikander.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sikander.presentation.databinding.ArticleItemBinding
import com.sikander.presentation.entity.ArticleUI

class ArticleViewHolder(val itemBinding: ArticleItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(article: ArticleUI) = with(itemView) {
        itemBinding.tvArticleTitle.text = article.description
        itemBinding.tvArticleAuthor.text = article.tagline
        itemBinding.tvArticleFirstLetter.text = article.description
    }

}