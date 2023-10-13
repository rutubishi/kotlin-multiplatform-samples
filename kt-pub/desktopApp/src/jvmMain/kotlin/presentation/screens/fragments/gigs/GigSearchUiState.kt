package presentation.screens.fragments.gigs

import data.network.GigResponse

data class GigSearchUiState(
    val searchTerm: String = "",
    val searchResults: List<GigResponse> = emptyList()
){
    fun isSearchValid() = searchTerm.isNotBlank()
}

sealed class GigSearchActions {
    data class SearchChange(val searchTerm: String): GigSearchActions()
    data object SubmitSearch : GigSearchActions()
}