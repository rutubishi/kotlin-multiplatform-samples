package com.rutubishi.fixtures

import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.koin.test.KoinTest

abstract class AppTest : KoinTest {

    fun baseTestApp(block: suspend ApplicationTestBuilder.() -> Unit ) = testApplication {
            environment {
                config = ApplicationConfig("application-test.yaml")
            }
            block()
    }

}
