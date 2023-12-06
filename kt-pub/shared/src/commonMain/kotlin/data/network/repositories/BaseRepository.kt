package data.network.repositories

import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
    //TODO: Fix repository
    suspend inline fun <reified T> collectDataFlow(crossinline block: suspend () -> T) = flow<T> {
        block()
    }
}