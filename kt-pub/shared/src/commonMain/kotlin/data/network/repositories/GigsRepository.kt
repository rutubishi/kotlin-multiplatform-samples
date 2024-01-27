package data.network.repositories

import data.network.*
import kotlinx.coroutines.flow.Flow

interface GigsRepository {
    suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>>
    suspend fun getGigStats(): Flow<AppResource<AppResponse<Map<String, Long>>>>
}

class GigsRepoImpl : GigsRepository, BaseRepository() {
    override suspend fun getLatestGigs(): Flow<AppResource<AppResponse<List<GigResponse>>>> =
        apiService.get<List<GigResponse>>(AppRouter.showGigsLatest)

    override suspend fun getGigStats(): Flow<AppResource<AppResponse<Map<String, Long>>>> =
        apiService.get<Map<String, Long>>(AppRouter.aggregateGigs)
}