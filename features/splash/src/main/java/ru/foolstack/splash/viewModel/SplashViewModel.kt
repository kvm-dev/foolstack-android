package ru.foolstack.splash.viewModel

import ru.foolstack.splash.interactor.SplashInteractor
import ru.local.viewmodel.BaseViewModel
class SplashViewModel(private val interactor: SplashInteractor): BaseViewModel() {
    fun superTest() = 25
    fun getLocal() = interactor.getLocal()
    fun getNetworkStatus() = interactor.getNetworkStatus()

}