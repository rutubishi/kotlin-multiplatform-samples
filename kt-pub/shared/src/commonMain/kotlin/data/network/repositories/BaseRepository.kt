package data.network.repositories

import data.network.ApiService
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    val apiService = ApiService

    //TODO: Fix repository
    suspend inline fun <reified T> collectDataFlow(crossinline block: suspend () -> T) = flow<T> {
        block()
    }
}