package ru.local.network.model.responses

import kotlinx.serialization.SerialName
import ru.local.utils.mappers.DataTransferObject

open class BaseResponse(
    @SerialName("message") var message: String? = null,
    @SerialName("errors") var errors: Map<String, String>? = null,
) : DataTransferObject
