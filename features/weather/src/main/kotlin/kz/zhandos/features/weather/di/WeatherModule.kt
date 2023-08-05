package kz.zhandos.features.weather.di

import kz.zhandos.features.weather.presentation.screen.FirstViewModel
import kz.zhandos.features.weather.presentation.screen2.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    viewModel { FirstViewModel() }
    viewModel { SecondViewModel() }

}