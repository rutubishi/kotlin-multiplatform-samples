package com.rutubishi.di

import com.rutubishi.data.database.*
import com.rutubishi.data.repository.EmployerRepoImpl
import com.rutubishi.data.repository.EmployerRepository
import com.rutubishi.data.repository.GigRepoImpl
import com.rutubishi.data.repository.GigRepository
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.module

val serverModule = module {
    // Database
    single <HikariDataSource> { AppDataSource }
    single <EmployerDAO>{ EmployerDAOImpl() }
    single <GigDAO>{ GigDAOImpl(employerDAO = get()) }
    single <EmployerRepository>{ EmployerRepoImpl(employerDAO = get()) }
    single <GigRepository>{ GigRepoImpl(gigDAO = get()) }
}