package presentation.screens.fragments.employers

import data.network.EmployerDto

data class EmployerSearchUiState(
    val searchTerm: String = "",
    val searchResults: List<EmployerDto> = emptyList()
){
    fun isSearchValid() = searchTerm.isNotBlank()
}

sealed class EmployerSearchActions{
    data class SearchChange(val searchTerm: String): EmployerSearchActions()
    data object SubmitSearch : EmployerSearchActions()
}