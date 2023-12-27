package ru.foolstack.local.di

import ru.foolstack.local.api.domain.usecase.GetLocalUseCase
import ru.foolstack.local.impl.domain.usecase.GetLocalUseCaseImpl
import org.koin.dsl.module

val localModule = module {
    single<GetLocalUseCase> { GetLocalUseCaseImpl() }
}