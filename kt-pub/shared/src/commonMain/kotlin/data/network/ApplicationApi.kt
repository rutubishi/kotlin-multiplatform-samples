package data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*

object ApplicationApi {
    private val client = appClient().apply {
        config {
            defaultRequest {
                host = "http://192.168.2.105:8080"
                url {
                    protocol = URLProtocol.HTTP
                }
            }
        }
    }

    /**
     * Application Endpoints
     * */
    suspend fun getLatestJobs(): AppResponse<List<GigResponse>> {
        return try {
            val request = client.get("http://192.168.2.105:8080"+AppRouter.showGigsLatest)
            println("Data: ${request.body<GigResponse>()}")
            return request.body()
        }catch (exception: Exception){
            AppResponse(code = 500, status = exception.message!!, body = emptyList())
        }
    }


}

expect fun appClient(): HttpClient