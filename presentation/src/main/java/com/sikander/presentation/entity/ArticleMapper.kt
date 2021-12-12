package com.sikander.presentation.entity

import com.sikander.domain.articles.entity.Article
import com.sikander.domain.base.mapper.Mapper

class ArticleMapper : Mapper<Article, ArticleUI> {

    override fun mapLeftToRight(obj: Article): ArticleUI = with(obj) {
        ArticleUI(
            id = id,
            name = name,
            tagline = tagline,
            description = description,
            imageUrl = imageUrl,
            abv = abv
        )
    }

}