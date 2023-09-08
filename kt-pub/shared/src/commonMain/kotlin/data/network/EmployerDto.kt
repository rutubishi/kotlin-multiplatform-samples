package data.network

import kotlinx.serialization.Serializable

@Serializable
data class EmployerDto(
    val id: Long = 0L,
    val title: String,
    val logo: String,
    val description: String,
    val webPage: String,
    val industry: String
)
