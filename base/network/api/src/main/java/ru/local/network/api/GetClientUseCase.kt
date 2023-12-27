package ru.local.network.api

import ru.local.network.model.responses.UserResponse

interface GetClientUseCase {

    operator fun invoke(): UserResponse

    companion object{
        val USER_TOKEN = "GetClientUseCase.USER_TOKEN"
    }
}