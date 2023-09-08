package com.rutubishi.plugins

import com.rutubishi.data.repository.EmployerRepository
import com.rutubishi.data.repository.GigRepository
import com.rutubishi.router.employerRouter
import com.rutubishi.router.gigRouter
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val gigRepository: GigRepository by inject()
    val employerRepository: EmployerRepository by inject()

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }

    gigRouter(gigRepository)
    employerRouter(employerRepository)

}
