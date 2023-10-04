package presentation.screens.fragments.gigs

import data.network.GigRequest


private val roleTypes = listOf("full-time", "part-time")
private val contractTypes = listOf("contract","permanent")
private val locTypes = listOf("Hybrid", "On-Site", "Remote")

data class GigAddUiState(
    val employerId: Long = 0L,
    val roleName: String? = null,
    val roleType: String? =  null,
    val salaryRange: String? =  null,
    val employer: String? = null,
    val roleLocation: String? = null,
    val location: String? =  null,
    val roleDesc: String? = null,
    val roleRequirement: String? = null,
    val roleBenefits: String? = null,
    val contractType: String? = null,
){
    fun valid(): Boolean =
        !roleName.isNullOrEmpty()
                && roleTypes.contains(roleType?.lowercase())
                && !salaryRange.isNullOrEmpty()
                && locTypes.contains(roleLocation)
                && !location.isNullOrEmpty()
                && !roleDesc.isNullOrEmpty()
                && !roleRequirement.isNullOrEmpty()
                && contractTypes.contains(contractType?.lowercase())
                && employerId != 0L

    fun getGigRequest() = GigRequest(
        title = roleName!!,
        description = roleDesc!!,
        requirements = roleRequirement!!,
        location = location!!,
        benefits = roleBenefits,
        roleType = roleType!!.lowercase(),
        locType = roleLocation!!,
        contractType = contractType!!.lowercase(),
        employerId = employerId,
        salaryRange = salaryRange!!
    )
}

sealed class GigAddActions {
    data class TitleChange(val title: String): GigAddActions()
    data class DescriptionChange(val description: String): GigAddActions()
    data class RequirementChange(val requirement: String): GigAddActions()
    data class LocationChange(val location: String): GigAddActions()
    data class BenefitsChange(val benefits: String?): GigAddActions()
    data class RoleTypeChange(val roleType: String): GigAddActions()
    data class LocTypeChange(val locType: String): GigAddActions()
    data class ContractTypeChange(val contractType: String): GigAddActions()
    data class SalaryRangeChange(val salaryRange: String): GigAddActions()
    data class SubmitGig(val employerId: Long): GigAddActions()
}