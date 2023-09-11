package com.rutubishi.fixtures

import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.koin.test.KoinTest
import kotlin.test.assertEquals

abstract class AppTest : KoinTest {

    fun baseTestApp(block: suspend ApplicationTestBuilder.() -> Unit ) = testApplication {
            environment {
                config = ApplicationConfig("application-test.yaml")
            }
            block()
    }

    fun HttpResponse.assertOkStatus() = assertEquals(HttpStatusCode.OK, status)

    fun HttpResponse.assertCreatedStatus() = assertEquals(HttpStatusCode.Created, status)

}
