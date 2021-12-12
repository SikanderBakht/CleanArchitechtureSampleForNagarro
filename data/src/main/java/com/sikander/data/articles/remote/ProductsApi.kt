package com.sikander.data.articles.remote

import com.sikander.data.BuildConfig
import com.sikander.data.articles.entity.ArticleResponse
import com.sikander.data.network.BaseApiService
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi : BaseApiService {
/*

    @GET("beers")
    fun getBeersList(
        */
/*@Query("ids") ids: String,*//*

        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 40,
    ): Single<GenericNetworkResponse<List<ArticleResponse>>>
*/

    @GET("/svc/mostpopular/v2/viewed/1.json")
    suspend fun getBeersListByCoroutine(
        /*@Query("ids") ids: String,*/
        @Query("api-key") page: String = "eDit4rvwgo5MDgTzEdyTe1hQKrTe9QVW",
        /*@Query("per_page") perPage: Int = 40,*/
    ): List<ArticleResponse>

}