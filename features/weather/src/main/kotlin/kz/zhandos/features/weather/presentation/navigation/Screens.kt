package kz.zhandos.features.weather.presentation.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import kz.zhandos.features.weather.presentation.current.CurrentWeatherFragment
import kz.zhandos.features.weather.presentation.list.WeatherListFragment

object Screens {
    fun ScreenCurrentWeather() = FragmentScreen { CurrentWeatherFragment() }
    fun ScreenListWeather() = FragmentScreen { WeatherListFragment() }

}