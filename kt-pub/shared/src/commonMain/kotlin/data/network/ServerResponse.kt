package data.network

import kotlinx.serialization.Serializable

@Serializable
data class AppResponse <T>(
    val code: Int = 200,
    val status: String = "Success",
    val body: T? = null
){
    fun logResponse(): AppResponse<T> {
        println("Response: $body")
        return this.copy()
    }
}

// UI Actions/ Resource
sealed class AppResource<S> (val res: AppResponse<S>? = null) {
    data class Loading<T>(val response: AppResponse<T> = AppResponse()): AppResource<T>(response)
    data class Success<T> (val response: AppResponse<T>): AppResource<T>(response)
    data class Error<T> (val response: AppResponse<T>): AppResource<T>(response)
}