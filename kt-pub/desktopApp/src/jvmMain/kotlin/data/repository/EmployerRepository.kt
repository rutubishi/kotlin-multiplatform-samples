package data.repository

import data.network.AppResponse
import data.network.AppRouter
import data.network.EmployerDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface EmployerRepository {
    suspend fun createEmployer(employer: EmployerDto): AppResponse<EmployerDto?>
    suspend fun showEmployers(): AppResponse<List<EmployerDto>>
    suspend fun getEmployer(id: Long): AppResponse<EmployerDto?>
}

class EmployerRepoImpl(
    private val client: HttpClient
) : EmployerRepository {
    override suspend fun createEmployer(employer: EmployerDto): AppResponse<EmployerDto?> {
        return try {
            client.post(AppRouter.createEmployer){
                setBody(employer)
            }.body<AppResponse<EmployerDto?>>()
        }catch (e: Exception){
            AppResponse(code = 500, status = e.message!!, body = null)
        }
    }

    override suspend fun showEmployers(): AppResponse<List<EmployerDto>> {
        return try {
            client.get(AppRouter.showEmployers).body<AppResponse<List<EmployerDto>>>()
        }catch (e: Exception){
            AppResponse(code = 500, status = e.message!!, body = emptyList())
        }
    }

    override suspend fun getEmployer(id: Long): AppResponse<EmployerDto?> {
        return try {
            client.get(AppRouter.BASE_EMPLOYER + id).body<AppResponse<EmployerDto?>>()
        }catch (e: Exception){
            AppResponse(code = 500, status = e.message!!, body = null)
        }
    }

}