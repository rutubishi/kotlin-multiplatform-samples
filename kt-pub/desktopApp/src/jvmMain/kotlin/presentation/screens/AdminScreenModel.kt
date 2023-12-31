package presentation.screens

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import presentation.uimodel.ScreenModel

class AdminScreenModel : ScreenModel {
    override val asyncWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)
    override val uiWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)

    val currentPage = MutableStateFlow(AdminUiState())

    fun handleNavigation(actions: AdminNavigationActions){
        when(actions){
            AdminNavigationActions.NavigateToEmployer -> {
                currentPage.update {
                    AdminUiState(currentScreen = AdminScreen.EmployerScreen)
                }
            }
            is AdminNavigationActions.NavigateToGig -> {
                currentPage.update {
                    AdminUiState(currentScreen = AdminScreen.GigScreen(employerId = actions.employerId))
                }
            }
            AdminNavigationActions.NavigateToHome -> {
                currentPage.update {
                    AdminUiState(currentScreen = AdminScreen.HomeScreen)
                }
            }
        }
    }


}

data class AdminUiState(
    val currentScreen: AdminScreen = AdminScreen.HomeScreen
)

sealed class AdminNavigationActions {
    data object NavigateToHome: AdminNavigationActions()
    data object NavigateToEmployer: AdminNavigationActions()
    data class NavigateToGig(val employerId: Long): AdminNavigationActions()
}