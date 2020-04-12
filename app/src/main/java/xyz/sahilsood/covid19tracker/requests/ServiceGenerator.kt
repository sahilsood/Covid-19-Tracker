package xyz.sahilsood.covid19tracker.requests

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com/")
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofit =
        retrofitBuilder.build()
    val covid19Api: Covid19Api =
        retrofit.create(
            Covid19Api::class.java
        )

    private val retrofitBuilder1 = Retrofit.Builder()
        .baseUrl("https://covidtracking.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofit1 =
        retrofitBuilder1.build()
    val covid19Api1: Covid19Api =
        retrofit1.create(
            Covid19Api::class.java
        )

    private val retrofitBuilder3 = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofit3 =
        retrofitBuilder3.build()
    val newsApi: NewsApi =
        retrofit3.create(
            NewsApi::class.java
        )
}