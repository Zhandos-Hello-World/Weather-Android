package kz.zhandos.features.weather.data.api

import kz.zhandos.features.weather.data.model.WeatherCurrentResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("mode") mode: String,
        @Query("lang") lang: String,
    ): WeatherCurrentResponse
}