package com.rutubishi.data.database

import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Database Setup
 * */
object AppDbFactory {

    private val SCHEMAS = arrayOf(
        Employers, Gigs
    )

    fun init(
        dataSource: HikariDataSource
    ) {
        Database.connect(dataSource)
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(*SCHEMAS)
        }
    }

    suspend fun <T> dbQuery(execution: suspend () -> T) : T =
        newSuspendedTransaction(Dispatchers.IO) { execution() }

}

object AppDataSource : HikariDataSource() {
    init {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://localhost:5432/kt-pub?user=kt-pub&password=change_password"
        maximumPoolSize = 5
        isAutoCommit = true
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
}