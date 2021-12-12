package com.sikander.data.articles.remote

import com.google.gson.JsonObject
import com.sikander.data.BuildConfig
import com.sikander.data.articles.entity.ArticleListResponse
import com.sikander.data.articles.entity.ArticleResponse
import com.sikander.data.network.BaseApiService
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService : BaseApiService {
/*

    @GET("beers")
    fun getBeersList(
        */
/*@Query("ids") ids: String,*//*

        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 40,
    ): Single<GenericNetworkResponse<List<ArticleResponse>>>
*/

    @GET("beers")
    suspend fun getArticlesListByCoroutine(
        /*@Query("ids") ids: String,*/
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 40,
    ): List<ArticleResponse>

    @GET("/svc/mostpopular/v2/viewed/1.json")
    suspend fun sampleGet(@Query("api-key") page: String): ArticleListResponse

}