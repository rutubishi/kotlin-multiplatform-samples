package data.network.repositories

import data.network.*
import kotlinx.coroutines.flow.Flow

interface GigsRepository {
    suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>>
}

class GigsRepoImpl(
    private val apiService: ApiService = ApiService()
): GigsRepository, BaseRepository() {

    override suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>> =
        apiService.get<List<GigResponse>>(AppRouter.showGigsLatest)
}