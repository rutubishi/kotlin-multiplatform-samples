package data.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*

actual fun appClient(): HttpClient {
    return HttpClient(CIO)
}