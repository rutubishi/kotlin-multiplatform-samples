package com.rutubishi

import com.rutubishi.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

private fun Application.sharedModuleConfig(){
    configureDB()
    configureHTTP()
    configureSerialization()
    configureRouting()
}

fun Application.module() {
    configureDI()
    sharedModuleConfig()
}

fun Application.testModule(){
    configureTestDI()
    sharedModuleConfig()
}
