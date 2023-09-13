package com.rutubishi.fixtures

import data.network.EmployerDto
import data.network.GigRequest

val gigRequestFixture = GigRequest(
    title = "",
    description = "",
    requirements = "",
    location = "",
    benefits = null,
    roleType = "FULL_TIME",
    locType = "HYBRID",
    contractType = "PERMANENT",
    employerId = 1L,
    salaryRange = ""
)


val employerRequestFixture = EmployerDto(
    title = "",
    logo = "",
    description = "",
    webPage = "",
    industry = ""
)