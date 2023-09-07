package com.rutubishi.di

import com.rutubishi.data.database.*
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.module

val serverModule = module {
    // Database
    single <HikariDataSource> { AppDataSource }
    single <EmployerDAO>{ EmployerDAOImpl() }
    single <GigDAO>{ GigDAOImpl(employerDAO = get()) }
}