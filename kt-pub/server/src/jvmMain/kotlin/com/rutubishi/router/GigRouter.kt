package com.rutubishi.router

import com.rutubishi.data.repository.GigRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import network.AppResponse
import network.GigRequest
import org.koin.ktor.ext.inject

fun Application.gigRouter() {

    val gigRepo: GigRepository by inject()

    routing {

        post(AppRouter.createGig){
            val gig = gigRepo.addGig(call.receive<GigRequest>())
            call.respond(AppResponse(body = gig))
        }

        get(AppRouter.showAllGigs){

        }

        get(AppRouter.showGigsLatest){

        }

    }
}