package com.rutubishi.data.repository

import com.rutubishi.data.database.Employer
import com.rutubishi.data.database.EmployerDAO

interface EmployerRepository {
    suspend fun searchEmployer(searchTerm: String): List<Employer>
    suspend fun getEmployer(id: Long): Employer?
}

class EmployerRepoImpl(
    private val employerDAO: EmployerDAO
) : EmployerRepository {
    override suspend fun searchEmployer(searchTerm: String): List<Employer>  =
        employerDAO.searchEmployer(searchTerm)

    override suspend fun getEmployer(id: Long): Employer? =
        employerDAO.getEmployer(id)
}