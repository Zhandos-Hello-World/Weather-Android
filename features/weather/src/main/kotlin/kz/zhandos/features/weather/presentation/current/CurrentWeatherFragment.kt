package kz.zhandos.features.weather.presentation.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.zhandos.features.weather.databinding.FragmentCurrentWeatherBinding
import kz.zhandos.features.weather.presentation.model.WeatherDvo
import kz.zhandos.lib.coreui.base.BaseFragment
import kz.zhandos.lib.coreui.base.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrentWeatherFragment :
    BaseFragment<CurrentWeatherViewModel, FragmentCurrentWeatherBinding>() {
    override val viewModel: CurrentWeatherViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentCurrentWeatherBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.flowWithLifecycle(lifecycle).onEach(::render).launchIn(lifecycleScope)

        viewModel.getCurrentWeather()
    }


    private fun render(state: ViewState) {
        hideAll()
        when (state) {
            is ViewState.Data<*> -> {
                (state.data as? WeatherDvo)?.let {
                    viewBinding.dataScreen.isVisible = true
                    dataFetched(it)
                }
            }

            ViewState.Error -> {
                viewBinding.reloadBtn.apply {
                    isVisible = true
                    setOnClickListener {
                        viewModel.getCurrentWeather()
                    }
                }
            }

            ViewState.Loading -> {
                viewBinding.loadingState.isVisible = true
            }
        }
    }

    private fun dataFetched(dvo: WeatherDvo) {
        viewBinding.weatherBanner.apply {
            currentTemp = dvo.temp
            location = "Almaty, Kazakhstan"
            description = dvo.status
            feelsLikeTemp = dvo.feelsLike
            currentDataAndTime = dvo.dateAndTime
        }
        viewBinding.apply {
            wind.info = dvo.windSpeed
            pressure.info = dvo.pressure
            humidity.info = dvo.humidity
            seaLevel.info = dvo.seaLevel
        }
        viewBinding.showList.setOnClickListener {
            viewModel.navigateToWeatherList()
        }
    }

    private fun hideAll() {
        viewBinding.apply {
            loadingState.isVisible = false
            dataScreen.isVisible = false
            reloadBtn.isVisible = false
        }
    }
}