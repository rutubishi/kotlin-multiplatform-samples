package presentation.screens

sealed class AdminScreen(param: String? = null) {
    data object EmployerScreen : AdminScreen()
    data class GigScreen(val param: String = "default") : AdminScreen(param = param)
    data object HomeScreen : AdminScreen()
}