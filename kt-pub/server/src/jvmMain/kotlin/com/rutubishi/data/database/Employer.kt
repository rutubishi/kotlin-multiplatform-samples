package com.rutubishi.data.database

import com.rutubishi.data.database.AppDbFactory.dbQuery
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

data class Employer(
    val id: Long = 0L,
    val title: String,
    val logo: String,
    val description: String,
    val webPage: String,
    val industry: String
)

object Employers : LongIdTable("employers"){
    val title = varchar(name = "name", length = 255)
    val logo = text("logo_url")
    val description = text("description")
    val webPage = text("website_url")
    val industry = varchar("industry", length = 155)
}

interface EmployerDAO {
    suspend fun addEmployer(employer: Employer): Employer?
    suspend fun getEmployer(id: Long): Employer?
    suspend fun getEmployerByIndustry(industry: String): List<Employer>
    suspend fun searchEmployer(searchTerm: String): List<Employer>
    suspend fun editEmployer(employer: Employer): Employer?
    suspend fun deleteEmployer(id: Long): Boolean
}

class EmployerDAOImpl : EmployerDAO {
    override suspend fun addEmployer(employer: Employer) : Employer? = dbQuery {
        val statement  = Employers.insert {
            it[title] = employer.title
            it[logo] = employer.logo
            it[description] = employer.description
            it[webPage] = employer.webPage
            it[industry] = employer.industry
        }
        statement.resultedValues?.singleOrNull()?.let(::rowToArticle)
    }

    override suspend fun getEmployer(id: Long): Employer? = dbQuery {
        Employers
            .select{ Employers.id eq id }
            .map(::rowToArticle)
            .singleOrNull()
    }

    override suspend fun getEmployerByIndustry(industry: String): List<Employer> = dbQuery {
        Employers
            .select { Employers.industry like industry }
            .map(::rowToArticle)
    }

    override suspend fun searchEmployer(searchTerm: String): List<Employer> = dbQuery {
        Employers
            .select { Employers.industry like searchTerm or (Employers.title like searchTerm) or (Employers.description like searchTerm) }
            .map(::rowToArticle)
    }

    override suspend fun editEmployer(employer: Employer): Employer?  = dbQuery {
        Employers.update({ Employers.id eq employer.id }) {
            it[title] = employer.title
            it[logo] = employer.logo
            it[description] = employer.description
            it[webPage] = employer.webPage
            it[industry] = employer.industry
        }
        getEmployer(employer.id)
    }

    override suspend fun deleteEmployer(id: Long): Boolean = dbQuery {
        Employers.deleteWhere { Employers.id eq id }
        true
    }

    private fun rowToArticle(row: ResultRow) = Employer(
        id = row[Employers.id].value,
        title = row[Employers.title],
        logo = row[Employers.logo],
        description = row[Employers.description],
        webPage = row[Employers.webPage],
        industry = row[Employers.industry]
    )
}


