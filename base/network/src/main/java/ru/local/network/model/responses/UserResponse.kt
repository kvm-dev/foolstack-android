package ru.local.network.model.responses

import kotlinx.serialization.SerialName

data class UserResponse(
    @SerialName("id") val id: Int,
    @SerialName("email") val email: String,
    @SerialName("token") val token: String,
    @SerialName("refresh_token") val refreshToken: String,
    @SerialName("profession") val profession: Profession,
    @SerialName("sub_profession") val subProfession: SubProfession,
    @SerialName("knowledge_areas") val knowledgeAreas: List<KnowledgeAreas>,
): BaseResponse()

data class Profession(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String
)

data class SubProfession(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String
)

data class KnowledgeAreas(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String
)