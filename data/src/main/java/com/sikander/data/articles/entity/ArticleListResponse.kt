package com.sikander.data.articles.entity

import com.google.gson.annotations.SerializedName

data class ArticleListResponse(
    @SerializedName("results") val results: ArrayList<NewArticleResponse>
)