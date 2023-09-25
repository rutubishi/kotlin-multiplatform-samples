package com.rutubishi.data.repository

import com.rutubishi.data.database.Employer
import com.rutubishi.data.database.EmployerDAO
import data.network.EmployerDto

interface EmployerRepository {
    suspend fun searchEmployer(searchTerm: String? = null): List<Employer>
    suspend fun getEmployer(id: Long): EmployerDto?
    suspend fun addEmployer(employerDto: EmployerDto): Employer?
}

class EmployerRepoImpl(
    private val employerDAO: EmployerDAO
) : EmployerRepository {
    override suspend fun searchEmployer(searchTerm: String?): List<Employer> {
        return if (searchTerm.isNullOrEmpty())
                employerDAO.getAllEmployers()
            else
                employerDAO.searchEmployer(searchTerm)
    }


    override suspend fun getEmployer(id: Long): EmployerDto? =
        employerDAO.getEmployer(id)?.toDto()

    override suspend fun addEmployer(employerDto: EmployerDto): Employer? {
        return with(employerDto){
            employerDAO.addEmployer(
                Employer(
                    title = title,
                    logo = logo,
                    description = description,
                    webPage = webPage,
                    industry = industry
                )
            )
        }

    }
}