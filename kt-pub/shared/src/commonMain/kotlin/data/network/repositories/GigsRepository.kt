package data.network.repositories

import data.network.AppResponse
import data.network.ApplicationApi
import data.network.GigResponse

interface GigsRepository {
    suspend fun fetchLatestGigs(): AppResponse<List<GigResponse>>
}

class GigsRepoImpl(
    private val api: ApplicationApi = ApplicationApi
): GigsRepository {
    override suspend fun fetchLatestGigs(): AppResponse<List<GigResponse>> {
        return api.getLatestJobs()
    }
}