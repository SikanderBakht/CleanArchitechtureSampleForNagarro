package com.sikander.domain.articles.entity

data class Article(
    val id: Int,
    val name: String,
    val title: String,
    val byLine: String,
    val publishedDate: String?
)