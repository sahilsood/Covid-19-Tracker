package xyz.sahilsood.covid19tracker.requests

import retrofit2.http.GET
import xyz.sahilsood.covid19tracker.models.StateInfo
import xyz.sahilsood.covid19tracker.models.States
import xyz.sahilsood.covid19tracker.models.Summary

interface Covid19Api {
    @GET("summary")
    suspend fun summary(): Summary

    @GET("states/current.json")
    suspend fun states(): States

    @GET("states/info.json")
    suspend fun stateInfo(): StateInfo
}