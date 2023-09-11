package com.rutubishi.fixtures

import com.rutubishi.di.sharedServerModule
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.module

val serverTestModule = module {
    sharedServerModule {
        single <HikariDataSource> { AppTest.TestDB }
    }
}