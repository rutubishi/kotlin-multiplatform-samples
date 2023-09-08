package data.network

import kotlinx.serialization.Serializable


@Serializable
data class GigRequest(
    val id: Long? = null,
    val title: String,
    val description: String,
    val requirements: String,
    val location: String,
    val benefits: String? = null,
    val roleType: String,
    val locType: String,
    val contractType: String,
    val employerId: Long
)

@Serializable
data class GigResponse(
    val id: Long,
    val title: String,
    val description: String,
    val requirements: String,
    val location: String,
    val benefits: String?,
    val roleType: String,
    val locType: String,
    val contractType: String,
    val employerId: Long,
    val employer: String,
    val employerLogo: String,
    val datePosted: String
)