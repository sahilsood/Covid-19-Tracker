package xyz.sahilsood.covid19tracker.repositories


import android.content.res.Resources
import xyz.sahilsood.covid19tracker.R
import xyz.sahilsood.covid19tracker.requests.ServiceGenerator.covid19Api
import xyz.sahilsood.covid19tracker.requests.ServiceGenerator.covid19Api1
import xyz.sahilsood.covid19tracker.requests.ServiceGenerator.newsApi

object AppRepository {

    suspend fun summaryLiveData() = covid19Api.summary()

    suspend fun stateLiveData() = covid19Api1.states()

    suspend fun getNewsData() = newsApi.getNews(
        "us",
        "ac003d78122f41969661667ef749a4ab",
        "coronavirus"
    )
}