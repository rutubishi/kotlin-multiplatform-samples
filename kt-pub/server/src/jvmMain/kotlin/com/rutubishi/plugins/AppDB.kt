package com.rutubishi.plugins

import com.rutubishi.data.database.AppDbFactory
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureDB(){
    val dataSource: HikariDataSource by inject()
    AppDbFactory.init(dataSource)
}