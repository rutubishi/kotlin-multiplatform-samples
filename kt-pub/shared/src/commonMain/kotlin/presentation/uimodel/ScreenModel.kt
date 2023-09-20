package presentation.uimodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface ScreenModel {
    val asyncWorkScope: CoroutineScope
    val uiWorkScope: CoroutineScope
    fun <T>launchInIO(execution: suspend () -> T) : Job =
        asyncWorkScope.launch { execution() }
    fun <T>launchInUI(execution: suspend () -> T) : Job =
        uiWorkScope.launch { execution() }
}