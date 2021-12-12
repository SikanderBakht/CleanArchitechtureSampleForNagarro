package com.sikander.data.articles.entity

import com.sikander.domain.articles.entity.Article
import com.sikander.domain.base.mapper.Mapper


class ArticleMapper : Mapper<ArticleResponse, Article> {

    override fun mapLeftToRight(obj: ArticleResponse): Article = with(obj) {
        Article(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            imageUrl = imageUrl,
            abv = abv
        )
    }

}