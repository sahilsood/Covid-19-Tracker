package xyz.sahilsood.covid19tracker.requests

import retrofit2.http.GET
import retrofit2.http.Query
import xyz.sahilsood.covid19tracker.models.News

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?,
        @Query("q") q: String?
    ): News
}