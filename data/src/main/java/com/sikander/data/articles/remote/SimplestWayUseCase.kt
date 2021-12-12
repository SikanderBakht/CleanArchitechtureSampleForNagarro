package com.sikander.data.articles.remote

import com.google.gson.JsonObject
import com.sikander.data.BuildConfig
import com.sikander.data.articles.entity.ArticleListResponse
import javax.inject.Inject

class SampleUseCase @Inject constructor(
    private val apIs: ApiService
) {
    suspend operator fun invoke(): ArticleListResponse {
        val response = apIs.sampleGet(BuildConfig.API_KEY)
        //here you can add some domain logic or call another UseCase
        return response
    }
}