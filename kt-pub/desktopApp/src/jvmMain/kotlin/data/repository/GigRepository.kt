package data.repository

import data.network.AppResponse
import data.network.AppRouter
import data.network.GigRequest
import data.network.GigResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface GigRepository {
    suspend fun createGig(gig: GigRequest): AppResponse<GigResponse?>
    suspend fun showGigs(): AppResponse<List<GigResponse>>
}

class GigRepoImpl(
    private val client: HttpClient
): GigRepository{
    override suspend fun createGig(gig: GigRequest): AppResponse<GigResponse?> {
        return try {
            client.post(AppRouter.createGig){
                setBody(gig)
            }.body<AppResponse<GigResponse?>>()
        }catch (e: Exception){
            AppResponse(code = 500, status = e.message!!, body = null)
        }
    }

    override suspend fun showGigs(): AppResponse<List<GigResponse>> {
        return try {
            client.get(AppRouter.showAllGigs).body<AppResponse<List<GigResponse>>>()
        }catch (e: Exception){
            AppResponse(code = 500, status = e.message!!, body = emptyList())
        }
    }
}
