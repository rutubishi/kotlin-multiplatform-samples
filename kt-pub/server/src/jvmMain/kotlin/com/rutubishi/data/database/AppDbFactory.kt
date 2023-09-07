package com.rutubishi.data.database

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

/**
 * Database Setup
 * */
object AppDbFactory {
    suspend fun <T> dbQuery(execution: suspend () -> T) : T =
        newSuspendedTransaction(Dispatchers.IO) { execution() }

}