package com.rutubishi.router

import kotlinx.serialization.Serializable

object AppRouter {
    /**
     * Gigs Routes
     * */
    val createGig = "/gig/add"
    val getGig = "/gig/{id}"
    val showGigsLatest = "/gig/latest"
    val showAllGigs = "/gig/all"

    /**
    * Employer Routes
     * */
    val createEmployer = "/employer/add"
    val getEmployer = "/employer/{id}"
    val showEmployers = "/employer/all"

}