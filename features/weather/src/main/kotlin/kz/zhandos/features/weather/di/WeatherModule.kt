package kz.zhandos.features.weather.di

import kz.zhandos.features.weather.data.api.WeatherAPI
import kz.zhandos.features.weather.data.mapper.WeatherDtoMapper
import kz.zhandos.features.weather.data.repository.WeatherRepositoryImpl
import kz.zhandos.features.weather.domain.repository.WeatherRepository
import kz.zhandos.features.weather.presentation.mapper.WeatherDvoMapper
import kz.zhandos.features.weather.presentation.screen.CurrentWeatherViewModel
import kz.zhandos.features.weather.presentation.screen2.SecondViewModel
import kz.zhandos.lib.core.data.network.NetworkApiFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {

    single<WeatherAPI> { get<NetworkApiFactory>().createAuthorizedApi() }

    single<WeatherRepository> {
        WeatherRepositoryImpl(
            api = get(),
            mapper = get(),
        )
    }

    viewModel {
        CurrentWeatherViewModel(
            repo = get(),
            mapper = get(),
        )
    }
    viewModel { SecondViewModel() }

    factory { WeatherDtoMapper() }

    factory { WeatherDvoMapper() }
}