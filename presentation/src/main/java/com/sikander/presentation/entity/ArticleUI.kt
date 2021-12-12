package com.sikander.presentation.entity

import android.os.Parcelable
import com.sikander.presentation.base.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleUI(
    override val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String?,
    val abv: Double
) : RecyclerItem, Parcelable