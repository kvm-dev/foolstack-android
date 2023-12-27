package ru.foolstack.splash.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.foolstack.network.api.domain.usecase.GetNetworkConnectionUseCase
import ru.foolstack.network.data.impl.domain.usecase.GetNetworkConnectionUseCaseImpl
import ru.foolstack.splash.api.domain.usecase.GetLocalUseCase
import ru.foolstack.splash.impl.domain.usecase.GetLocalUseCaseImpl
import ru.foolstack.splash.interactor.SplashInteractor
import ru.foolstack.splash.viewModel.SplashViewModel

val splashModule = module {
//    includes(localModule)
//    single<GetLocalUseCase> { GetLocalUseCaseImpl() }
//    factory { SplashInteractor(get()) }
    factory { SplashInteractor(getLocalUseCase = GetLocalUseCaseImpl(), getNetworkConnectionUseCase = GetNetworkConnectionUseCaseImpl(androidContext())) }
    viewModel { SplashViewModel(get()) }
}