package com.sikander.presentation.adapter

import android.view.View
import com.sikander.presentation.base.RecyclerItem
import com.sikander.presentation.entity.ArticleCell

class ArticleListAdapter(onItemClick: (RecyclerItem, View) -> Unit) : BasePagedListAdapter(
    ArticleCell,
    onItemClick = onItemClick
)