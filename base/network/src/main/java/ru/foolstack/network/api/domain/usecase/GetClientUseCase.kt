package ru.foolstack.network.api.domain.usecase

import ru.foolstack.network.api.model.responses.UserResponse

interface GetClientUseCase {

    operator fun invoke(): UserResponse

    companion object{
        val USER_TOKEN = "GetClientUseCase.USER_TOKEN"
    }
}