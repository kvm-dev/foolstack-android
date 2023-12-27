package ru.foolstack.splash.interactor

import ru.foolstack.network.api.domain.usecase.GetNetworkConnectionUseCase
import ru.foolstack.splash.api.domain.usecase.GetLocalUseCase


class SplashInteractor(
    private val getLocalUseCase: GetLocalUseCase,
    private val getNetworkConnectionUseCase: GetNetworkConnectionUseCase
) {
    fun getLocal() = getLocalUseCase.getUseCase()

    fun getNetworkStatus() = getNetworkConnectionUseCase.getConnectionStatus()

}