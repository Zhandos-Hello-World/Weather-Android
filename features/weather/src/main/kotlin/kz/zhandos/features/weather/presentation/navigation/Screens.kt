package kz.zhandos.features.weather.presentation.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import kz.zhandos.features.weather.presentation.screen.CurrentWeatherFragment
import kz.zhandos.features.weather.presentation.screen2.SecondFragment

object Screens {
    fun ScreenFirst() = FragmentScreen { CurrentWeatherFragment() }
    fun ScreenSecond() = FragmentScreen { SecondFragment() }

}