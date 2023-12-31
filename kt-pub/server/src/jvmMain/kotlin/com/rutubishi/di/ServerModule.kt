package com.rutubishi.di

import com.rutubishi.data.database.*
import com.rutubishi.data.repository.EmployerRepoImpl
import com.rutubishi.data.repository.EmployerRepository
import com.rutubishi.data.repository.GigRepoImpl
import com.rutubishi.data.repository.GigRepository
import com.zaxxer.hikari.HikariDataSource
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module

val serverModule = module {
    sharedServerModule {
        single <HikariDataSource> { AppDataSource }
    }
}

val serverTestModule = module {
    sharedServerModule {
        single <HikariDataSource> { HikariDataSource().apply {
            driverClassName = "org.h2.Driver"
            jdbcUrl = "jdbc:h2:mem:test;MODE=PostgreSQL"
            maximumPoolSize = 5
            isAutoCommit = true
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        } }
    }
}

inline fun Module.sharedServerModule (module: Module.() -> Unit){
    module()
    single <EmployerDAO>{ EmployerDAOImpl() }
    single <GigDAO>{ GigDAOImpl(employerDAO = get()) }
    single <EmployerRepository>{ EmployerRepoImpl(employerDAO = get()) }
    single <GigRepository>{ GigRepoImpl(gigDAO = get(), employerDAO = get()) }
}