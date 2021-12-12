package com.sikander.presentation.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sikander.presentation.R
import com.sikander.presentation.adapter.ArticleViewHolder
import com.sikander.presentation.adapter.Cell
import com.sikander.presentation.base.RecyclerItem
import com.sikander.presentation.databinding.ArticleItemBinding

object ArticleCell : Cell<RecyclerItem, ViewBinding> {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is ArticleUI
    }

    override fun type(): Int {
        return R.layout.article_item
    }

    override fun binding(parent: ViewGroup): ArticleItemBinding {
        return ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ArticleViewHolder(binding(parent))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem, View) -> Unit)?
    ) {
        if (holder is ArticleViewHolder && item is ArticleUI) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClick?.run {
                    this(item, holder.itemBinding.root)
                }
            }
        }
    }

}