package com.rutubishi.plugins

import com.rutubishi.di.serverModule
import com.rutubishi.di.serverTestModule
import io.ktor.server.application.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.ktor.plugin.koin
import org.koin.logger.slf4jLogger

fun Application.configureDI(){
    koin {
        slf4jLogger()
        modules(serverModule)
    }
}

fun Application.configureTestDI(){
    koin {
        slf4jLogger()
        modules(serverTestModule)
    }
}