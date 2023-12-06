package data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

// ktor client configuration
val client = HttpClient {
    install(ContentNegotiation){
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    defaultRequest {
        url("http://192.168.2.105:8080")
        contentType(ContentType.Application.Json)
    }
}


// API service setup
class ApiService {
    suspend inline fun <reified T> get(url: String) = makeRequest<T>(url, HttpMethod.Get)
    suspend inline fun <reified T> post(url: String) = makeRequest<T>(url, HttpMethod.Post)
    suspend inline fun <reified T> put(url: String) = makeRequest<T>(url, HttpMethod.Put)
    suspend inline fun <reified T> delete(url: String) = makeRequest<T>(url, HttpMethod.Delete)


    suspend inline fun <reified T> makeRequest(url: String, method: HttpMethod) = flow<AppResource<AppResponse<T>>> {
        emit(AppResource.Loading())
        try {
            val response = client.request(url){
                this.method = method
            }
            emit(
                AppResource.Success(
                    response = AppResponse(code = response.status.value, body = response.body())
                )
            )

        }catch (e: Exception){
            emit(
                AppResource.Error(
                    response = AppResponse(code = 500, status = e.message!!)
                )
            )
        }
    }


}


expect fun appClient(): HttpClient