package kz.zhandos.features.weather.domain.repository

import kz.zhandos.features.weather.domain.model.WeatherCurrent
import kz.zhandos.features.weather.domain.model.WeatherCurrentParams

interface WeatherRepository {

    suspend fun getCurrentWeather(params: WeatherCurrentParams): WeatherCurrent
}