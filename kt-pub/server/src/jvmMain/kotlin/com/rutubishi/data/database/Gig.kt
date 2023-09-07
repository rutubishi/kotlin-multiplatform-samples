package com.rutubishi.data.database

import com.rutubishi.data.database.AppDbFactory.dbQuery
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.util.*

data class Gig(
    val id: Long = 0L,
    val title: String,
    val description: String,
    val requirements: String,
    val location: String,
    val benefits: String? = null,
    val roleType: RoleType,
    val locType: LocType,
    val contractType: ContractType,
    val datePosted: LocalDate,
    val employer: Employer
)

enum class LocType(name: String) {
    HYBRID("Hybrid"),
    ON_SITE("On-Site"),
    REMOTE("Remote")
}

enum class RoleType(name: String){
    FULL_TIME("full-time"),
    PART_TIME("part-time")
}

enum class ContractType(name: String){
    CONTRACT("contract"),
    PERMANENT("permanent")
}

object Gigs : LongIdTable("gigs"){
    val title = varchar(name = "title", length = 255)
    val description = text("description")
    val requirements = text("requirements")
    val location = text("location")
    val benefits = text("benefits").nullable()
    val roleType = enumeration<RoleType>("role_type")
    val locType = enumeration<LocType>("location_type")
    val contractType = enumeration<ContractType>("contract_type")
    val datePosted = datetime("date_posted")
    val employer = reference("employer", Employers.id, onDelete = ReferenceOption.CASCADE)
}

interface GigDAO {
    suspend fun addGig(gig: Gig): Gig?
    suspend fun showGigs(count: Int? = null): List<Gig>

}

class GigDAOImpl(
    private val employerDAO: EmployerDAO
): GigDAO {
    override suspend fun addGig(gig: Gig): Gig? = dbQuery {
        val statement = Gigs.insert {
            it[title] = gig.title
            it[description] = gig.description
            it[requirements] = gig.requirements
            it[location] = gig.location
            it[benefits] = gig.benefits
            it[roleType] = gig.roleType
            it[locType] = gig.locType
            it[contractType] = gig.contractType
            it[datePosted] = LocalDateTime.parse(Date().toString())
            it[employer] = gig.employer.id
        }
        statement.resultedValues?.singleOrNull()?.let(::rowToGig)
    }

    override suspend fun showGigs(count: Int?): List<Gig> = dbQuery {
        if (count == null)
            Gigs
                .selectAll()
                .orderBy(Gigs.datePosted to SortOrder.DESC)
                .map(::rowToGig)
        else
            Gigs
                .selectAll()
                .orderBy(Gigs.datePosted to SortOrder.DESC)
                .limit(count)
                .map(::rowToGig)
    }

    private fun rowToGig(row: ResultRow): Gig {
        val employer = runBlocking {
            employerDAO.getEmployer(row[Gigs.employer].value)!!
        }
        return Gig(
            id = row[Gigs.id].value,
            title = row[Gigs.title],
            description = row[Gigs.description],
            requirements = row[Gigs.requirements],
            location = row[Gigs.location],
            benefits = row[Gigs.benefits],
            roleType = row[Gigs.roleType],
            locType = row[Gigs.locType],
            contractType = row[Gigs.contractType],
            datePosted = row[Gigs.datePosted].date,
            employer = employer
        )
    }
}



