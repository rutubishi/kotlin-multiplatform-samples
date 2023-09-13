package com.rutubishi.fixtures

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import org.koin.test.KoinTest
import kotlin.test.assertEquals

abstract class AppTest : KoinTest {

    fun baseTestApp(block: suspend ApplicationTestBuilder.(client: HttpClient) -> Unit ) = testApplication {
        environment {
            config = ApplicationConfig("application-test.yaml")
        }
        val client = createClient {
            install(ContentNegotiation){
                json()
            }
        }
        block(client)
    }

    fun HttpResponse.assertOkStatus() = assertEquals(HttpStatusCode.OK, status)

    fun HttpResponse.assertCreatedStatus() = assertEquals(HttpStatusCode.Created, status)

    inline fun <reified T> HttpRequestBuilder.configureTestRequest(body: T){
        contentType(ContentType.Application.Json)
        setBody(body)
    }

}
