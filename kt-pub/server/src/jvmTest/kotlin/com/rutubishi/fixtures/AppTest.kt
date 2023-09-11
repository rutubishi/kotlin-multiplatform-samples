package com.rutubishi.fixtures

import com.rutubishi.data.database.AppDbFactory
import com.rutubishi.plugins.configureHTTP
import com.rutubishi.plugins.configureRouting
import com.rutubishi.plugins.configureSerialization
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import io.ktor.server.testing.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

abstract class AppTest {
    fun baseTestApp(block: suspend ApplicationTestBuilder.() -> Unit ) = testApplication {
            application {
                configureTestDI()
                configureTestDB()
                configureHTTP()
                configureSerialization()
                configureRouting()
            }
            block()
    }


    private fun Application.configureTestDI(){
        install(Koin){
            slf4jLogger()
            modules(serverTestModule)
        }
    }

    private fun configureTestDB() {
        AppDbFactory.init(TestDB)
    }

    private object TestDB : HikariDataSource(){
        init {
            driverClassName = "org.h2.Driver"
            jdbcUrl = "jdbc:h2:mem:test"
            maximumPoolSize = 5
            isAutoCommit = true
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
    }

}