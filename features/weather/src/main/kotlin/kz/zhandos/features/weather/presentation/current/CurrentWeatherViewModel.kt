package kz.zhandos.features.weather.presentation.current

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.zhandos.features.weather.domain.model.WeatherCurrentParams
import kz.zhandos.features.weather.domain.repository.WeatherRepository
import kz.zhandos.features.weather.presentation.mapper.WeatherDvoMapper
import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.coreui.base.BaseViewModel
import kz.zhandos.lib.coreui.base.ViewState

class CurrentWeatherViewModel(
    private val repo: WeatherRepository,
    private val mapper: WeatherDvoMapper,
) : BaseViewModel() {
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState: StateFlow<ViewState> = _uiState.asStateFlow()

    init {
        getCurrentWeather()
    }

    fun getCurrentWeather() {
        dataRequest(
            dispatcher = Dispatchers.IO,
            loading = { loading ->
                if (loading) {
                    _uiState.tryEmit(ViewState.Loading)
                }
            },
            request = {
                repo.getCurrentWeather(
                    params = WeatherCurrentParams(
                        latitude = 43.237,
                        longitude = 76.838,
                    )
                )
            },
            onSuccess = { response ->
                val dvo = mapper.map(response)
                _uiState.tryEmit(
                    ViewState.Data(
                        dvo
                    )
                )
            },
            onError = {
                _uiState.tryEmit(ViewState.Error)
            },
        )
    }

    fun navigateToWeatherList() {
        router.navigateTo(Screens.ScreenListWeather())
    }
}