package ru.foolstack.network.api.model.responses

import kotlinx.serialization.SerialName
import ru.foolstack.utils.mappers.DataTransferObject

open class BaseResponse(
    @SerialName("message") var message: String? = null,
    @SerialName("errors") var errors: Map<String, String>? = null,
) : DataTransferObject
