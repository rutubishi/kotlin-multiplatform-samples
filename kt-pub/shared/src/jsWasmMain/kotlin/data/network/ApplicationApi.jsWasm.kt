package data.network

import io.ktor.client.*

actual fun appClient(): HttpClient {
    return HttpClient()
}