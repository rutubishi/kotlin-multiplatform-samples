package com.rutubishi.plugins

import com.rutubishi.fixtures.AppTest
import com.rutubishi.fixtures.employerRequestFixture
import data.network.AppResponse
import data.network.AppRouter
import data.network.EmployerDto
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlin.test.Test
import kotlin.test.assertEquals

class EmployerTest : AppTest() {
    @Test
    fun `should create, get, update and delete a new employer`() = baseTestApp { client ->
        client
            .post(AppRouter.createEmployer) { configureTestRequest(employerRequestFixture) }
        client.get(AppRouter.BASE_EMPLOYER + "1").apply {
            assertOkStatus()
            assertEquals(body<AppResponse<EmployerDto?>>().body, employerRequestFixture.copy(id = 1L))
        }
    }
}