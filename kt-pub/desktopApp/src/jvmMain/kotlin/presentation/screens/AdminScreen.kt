package presentation.screens

sealed class AdminScreen {
    data object EmployerScreen : AdminScreen()
    data object GigScreen : AdminScreen()
    data object HomeScreen : AdminScreen()
}