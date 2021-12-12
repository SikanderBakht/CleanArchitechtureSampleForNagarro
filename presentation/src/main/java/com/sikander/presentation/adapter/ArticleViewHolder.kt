package com.sikander.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sikander.presentation.databinding.ArticleItemBinding
import com.sikander.presentation.entity.ArticleUI

class ArticleViewHolder(val itemBinding: ArticleItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(beer: ArticleUI) = with(itemView) {
        itemBinding.tvArticleAuthor.text = beer.title
        /*itemBinding.itemProductContainer.transitionName = beer.id.toString()
        itemBinding.itemProductIdTxv.text = beer.id.toString()
        itemBinding.itemProductImv.load(beer.imageUrl)
        itemBinding.itemProductNameTxv.text = beer.name
        itemBinding.itemProductAbvTxv.text = beer.abv.toString()
        //itemBinding.itemProductTypeTxv.text = beer.type*/
    }

}