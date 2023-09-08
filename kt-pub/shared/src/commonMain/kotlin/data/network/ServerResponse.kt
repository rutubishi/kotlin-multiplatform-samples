package data.network

import kotlinx.serialization.Serializable

@Serializable
data class AppResponse <T>(
    val code: Int = 200,
    val status: String = "Success",
    val body: T
)