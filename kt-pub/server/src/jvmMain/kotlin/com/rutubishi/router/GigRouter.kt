package com.rutubishi.router

import com.rutubishi.data.repository.GigRepository
import data.network.AppResponse
import data.network.GigRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.gigRouter(
    gigRepository: GigRepository
) {

    routing {

        post(AppRouter.createGig){
            val gig = gigRepository.addGig(call.receive<GigRequest>())
            call.respond(
                status = HttpStatusCode.Created,
                message = AppResponse(
                    status = "Created Gig",
                    code = HttpStatusCode.Created.value,
                    body = gig?.toDto()
                )
            )
        }

        get(AppRouter.showAllGigs){
            val gigs = gigRepository.showGigs()
            call.respond(AppResponse(body = gigs.map { it.toDto() }))
        }

        get(AppRouter.showGigsLatest){

        }

    }
}