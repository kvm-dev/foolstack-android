package ru.foolstack.network.api.domain.usecase

interface GetNetworkConnectionUseCase {
    fun getConnectionStatus():Boolean
}