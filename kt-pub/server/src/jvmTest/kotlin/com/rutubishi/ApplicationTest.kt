package com.rutubishi

import com.rutubishi.fixtures.AppTest
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest : AppTest() {
    @Test
    fun testRoot() = baseTestApp {
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
