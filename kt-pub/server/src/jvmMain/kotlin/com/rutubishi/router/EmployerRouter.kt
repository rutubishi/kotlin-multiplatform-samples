package com.rutubishi.router

import com.rutubishi.data.repository.EmployerRepository
import data.network.AppResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.employerRouter(
    employerRepository: EmployerRepository
){
    routing {

        post(AppRouter.createEmployer) {
            val employer = employerRepository
                .addEmployer(call.receive())
            call.respond(AppResponse(body = employer?.toDto()))
        }

        get(AppRouter.showEmployers) {
            call.respond(AppResponse(body = employerRepository.searchEmployer().map { it.toDto() }))
        }

    }
}