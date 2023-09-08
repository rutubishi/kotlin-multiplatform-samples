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


}