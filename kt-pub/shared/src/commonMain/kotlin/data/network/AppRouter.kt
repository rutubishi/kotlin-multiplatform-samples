package data.network

object AppRouter {
    /**
     * Gigs Routes
     * */
    val createGig = "/gig/add"
    val getGig = "/gig/{id}"
    val showGigsLatest = "/gig/latest"
    val showAllGigs = "/gig/all"
    val aggregateGigs = "/gig/aggregate"

    /**
    * Employer Routes
     * */
    const val BASE_EMPLOYER = "/employer/"
    const val createEmployer = "/employer/add"
    const val getEmployer = "/employer/{id}"
    const val showEmployers = "/employer/all"

}