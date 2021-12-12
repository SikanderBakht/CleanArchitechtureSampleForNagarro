package com.sikander.data.articles.entity

import com.google.gson.annotations.SerializedName

data class NewArticleResponse(
    @SerializedName("title") val title: String,
    @SerializedName("byline") val byLine: String,
    @SerializedName("published_date") val publishedDate: String,

)