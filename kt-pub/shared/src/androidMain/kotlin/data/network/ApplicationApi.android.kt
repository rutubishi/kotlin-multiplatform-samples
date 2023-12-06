package data.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import java.net.InetSocketAddress
import java.net.Proxy

actual fun appClient(): HttpClient {
    return HttpClient(Android) {
//        engine {
//            proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(8080))
////            connectTimeout = 100_000
////            socketTimeout = 100_000
////            proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("0.0.0.0", 8080))
//        }
    }
}