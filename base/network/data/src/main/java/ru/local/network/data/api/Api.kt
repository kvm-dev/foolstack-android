package ru.local.network.data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import ru.local.network.api.Endpoints

class UserApi(private val client: HttpClient) {
    suspend fun getUserKtor(
        userToken: String
    ): HttpResponse = client.get("${Endpoints.CLIENT}")
}