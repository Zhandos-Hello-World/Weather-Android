package kz.zhandos.features.weather.presentation.screen2

import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.coreui.base.BaseViewModel

class SecondViewModel : BaseViewModel() {

    fun back() {
        router.backTo(Screens.ScreenFirst())
    }
}