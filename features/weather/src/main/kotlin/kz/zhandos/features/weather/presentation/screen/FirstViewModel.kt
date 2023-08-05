package kz.zhandos.features.weather.presentation.screen

import kz.zhandos.features.weather.presentation.navigation.Screens
import kz.zhandos.lib.coreui.base.BaseViewModel

class FirstViewModel : BaseViewModel() {

    fun navigateToSecondPage() {
        router.navigateTo(Screens.ScreenSecond())
    }
}