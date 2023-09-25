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
    title = "kt-pub",
    logo = "https://logo.com",
    description = "Kt pub here",
    webPage = "https://kt-pub.com",
    industry = "technology"
)