package com.rutubishi.router

import com.rutubishi.data.repository.EmployerRepository
import data.network.AppResponse
import data.network.AppRouter
import data.network.EmployerDto
import io.ktor.http.*
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
                .addEmployer(call.receive<EmployerDto>().copy())
            call.respond(status = HttpStatusCode.Created ,message = AppResponse(body = employer?.toDto()))
        }

        get(AppRouter.showEmployers) {
            call.respond(
                AppResponse(
                    body = employerRepository.searchEmployer().map { it.toDto() })
            )
        }

        get(AppRouter.getEmployer){
            call.respond(
                AppResponse(
                    body = employerRepository.getEmployer(call.parameters["id"]?.toLong()!!)
                )
            )
        }

    }
}