package presentation.screens

sealed class AdminScreen() {
    data object EmployerScreen : AdminScreen()
    data class GigScreen(val employerId: Long = 0L) : AdminScreen()
    data object HomeScreen : AdminScreen()
}