package presentation.screens.fragments.employers

import data.network.EmployerDto

data class EmployerAddUiState(
    val companyName: String? = null,
    val logo: String? = null,
    val webPage: String? = null,
    val industry: String? = null,
    val companySize: String? = null,
    val description: String? = null
){
    fun valid(): Boolean =
        !logo.isNullOrEmpty()
                && !webPage.isNullOrEmpty()
                && !industry.isNullOrEmpty()
                && !companySize.isNullOrEmpty()
                && !description.isNullOrEmpty()
                && !companyName.isNullOrEmpty()

    fun getEmployerDto() = EmployerDto(
        title = companyName!!,
        logo = logo!!,
        description = description!!,
        webPage = webPage!!,
        industry = industry!!
    )
}

sealed class EmployerAddActions {
    data class CompanyNameChange(val companyName: String): EmployerAddActions()
    data class LogoChange(val logo: String): EmployerAddActions()
    data class WebPageChange(val webPage: String): EmployerAddActions()
    data class IndustryChange(val industry: String): EmployerAddActions()
    data class CompanySizeChange(val companySize: String) : EmployerAddActions()
    data class DescriptionChange(val description: String) : EmployerAddActions()

    data object AddEmployer : EmployerAddActions()
}

