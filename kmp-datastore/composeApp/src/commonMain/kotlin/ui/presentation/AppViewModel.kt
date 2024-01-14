package ui.presentation

import com.rutubishi.kmpdatastore.core_data.repository.ThemeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    private val themeRepo: ThemeRepository,
    private val coroutineScope: CoroutineScope
) {

    private val _appUiState = MutableStateFlow(AppUiState())
    val appUiState: StateFlow<AppUiState> = _appUiState

    fun handleUiActions(actions: AppActions){
        when(actions){

            is AppActions.SwitchUiTheme -> {
                coroutineScope.launch {
                    themeRepo.changeTheme(actions.isDark).collectLatest { darkMode ->
                        _appUiState.update { it.copy(isDarkTheme = darkMode) }
                    }
                }
            }

            is AppActions.LaunchApp -> {
                coroutineScope.launch {
                    val isDarkMode = themeRepo.isInDarkMode().first()
                    _appUiState.update { it.copy(isDarkTheme = isDarkMode) }
                }
            }

        }
    }

}

data class AppUiState(
    val isDarkTheme: Boolean = false
)

sealed class AppActions{
    data class SwitchUiTheme(val isDark: Boolean): AppActions()
    data object LaunchApp: AppActions()
}