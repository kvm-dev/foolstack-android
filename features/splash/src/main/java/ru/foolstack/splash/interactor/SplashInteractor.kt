package ru.foolstack.splash.interactor

import ru.foolstack.splash.api.domain.usecase.GetLocalUseCase


class SplashInteractor(private val getLocalUseCase: GetLocalUseCase) {

    fun getLocal() = getLocalUseCase.getUseCase()

}