package com.rutubishi.plugins

import com.rutubishi.fixtures.AppTest
import com.rutubishi.fixtures.employerRequestFixture
import com.rutubishi.fixtures.gigRequestFixture
import com.rutubishi.router.AppRouter
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ResponsesTest : AppTest() {
    
    @AfterTest
    fun closeKoin(){
        stopKoin()
    }

    @Test
    fun `should show OK status`() = baseTestApp { client ->

        // documentation pages
        client.get("/openapi")
            .apply { assertOkStatus() }

        // Employer
        client.get(AppRouter.showEmployers)
            .apply { assertOkStatus() }

        // Gig
        client.get(AppRouter.showAllGigs)
            .apply { assertOkStatus() }

    }

    @Test
    fun `should show NOT FOUND status`() = baseTestApp { client ->
        client.get("/xyz-random")
            .apply { assertEquals(HttpStatusCode.NotFound, status) }
    }

    @Test
    fun `should show CREATED status`() = baseTestApp { client ->
        // Create Employer
        client
            .post(AppRouter.createEmployer) { configureTestRequest(employerRequestFixture) }
            .apply { assertCreatedStatus() }

        // Create Gig
        client
            .post(AppRouter.createGig){ configureTestRequest(gigRequestFixture) }
            .apply { assertCreatedStatus() }
    }

}