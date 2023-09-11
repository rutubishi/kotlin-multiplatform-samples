package com.rutubishi.plugins

import com.rutubishi.data.repository.EmployerRepository
import com.rutubishi.data.repository.GigRepository
import com.rutubishi.router.employerRouter
import com.rutubishi.router.gigRouter
import data.network.AppResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val gigRepository: GigRepository by inject()
    val employerRepository: EmployerRepository by inject()

    install(StatusPages) {
        status(HttpStatusCode.NotFound){ call, code ->
            call.respond(status = code, message = AppResponse(code = code.value, status = "Not found", body = null))
        }
        exception<Throwable> { call, cause ->
            call.respond(AppResponse(code = HttpStatusCode.InternalServerError.value, status = "Failed", body = "Cause: ${cause.message}"))
        }
        exception<ExposedSQLException> { call, cause  ->
            call.respond(AppResponse(code = HttpStatusCode.UnprocessableEntity.value, status = "Input Error", body = "Cause: ${cause.message}"))
        }
    }

    gigRouter(gigRepository)
    employerRouter(employerRepository)

}
