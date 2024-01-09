package data.network.repositories

import data.network.*
import kotlinx.coroutines.flow.Flow

interface GigsRepository {
    suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>>
}

class GigsRepoImpl : GigsRepository, BaseRepository() {
    override suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>> =
        apiService.get<List<GigResponse>>(AppRouter.showGigsLatest)
}