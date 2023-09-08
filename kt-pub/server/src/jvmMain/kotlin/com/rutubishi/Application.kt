package com.rutubishi

import com.rutubishi.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDI()
    configureDB()
    // configureSecurity()
    configureHTTP()
    configureSerialization()
    configureRouting()
}
