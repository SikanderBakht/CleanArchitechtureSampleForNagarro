package com.sikander.data.articles.entity


import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("byline") val byLine: String,
    @SerializedName("published_date") val publishedDate: String?
)