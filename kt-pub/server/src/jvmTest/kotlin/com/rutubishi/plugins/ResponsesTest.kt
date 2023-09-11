package com.rutubishi.plugins

import com.rutubishi.fixtures.AppTest
import com.rutubishi.router.AppRouter
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ResponsesTest : AppTest() {
    @Test
    fun `should show correct status codes`() = baseTestApp {

        client.get("/xyz-random").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }

        // Employer
        client.get(AppRouter.showEmployers).apply {
            assertEquals(HttpStatusCode.OK, status)
        }

        // Gig
        client.get(AppRouter.showAllGigs).apply {
            assertEquals(HttpStatusCode.OK, status)
        }

    }
}