package com.rutubishi.plugins

import com.rutubishi.di.serverModule
import io.ktor.server.application.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI(){
    install(Koin){
        slf4jLogger()
        modules(serverModule)
    }
}