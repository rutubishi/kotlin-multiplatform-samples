package com.rutubishi.data.repository

import com.rutubishi.data.database.*
import data.network.GigRequest
import io.ktor.server.util.*
import io.ktor.util.*
import kotlinx.datetime.*
import java.time.LocalDateTime
import java.util.Date

interface GigRepository {
    suspend fun showGigs(): List<Gig>
    suspend fun searchGig(searchTerm: String): List<Gig>
    suspend fun addGig(gigRequest: GigRequest): Gig?
    suspend fun showLatestGigs(latest: Int = 5): List<Gig>
}

class GigRepoImpl(
    private val gigDAO: GigDAO,
    private val employerDAO: EmployerDAO
) : GigRepository {
    override suspend fun showGigs(): List<Gig> = gigDAO.showGigs()

    override suspend fun searchGig(searchTerm: String): List<Gig> {
        TODO("Not yet implemented")
    }

    override suspend fun showLatestGigs(latest: Int): List<Gig> = gigDAO.showGigs(latest)
    override suspend fun addGig(gigRequest: GigRequest): Gig? {
        val employer = employerDAO.getEmployer(gigRequest.employerId)
        return if(employer == null)
            null
        else
          with(gigRequest){
                val gig = Gig(
                    title = title,
                    description = description,
                    requirements = requirements,
                    location = location,
                    benefits = benefits,
                    roleType = RoleType.FULL_TIME,
                    locType = LocType.valueOf(locType),
                    contractType = ContractType.valueOf(contractType),
                    datePosted = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
                    employer = employer,
                    salaryRange = salaryRange
                )
              gigDAO.addGig(gig)
            }
    }

}