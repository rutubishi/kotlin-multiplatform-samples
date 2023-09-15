package presentation.uimodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface ScreenModel {
    val asyncWorkScope:CoroutineScope
    fun <T>launchInModel(execution: suspend () -> T) : Job =
        asyncWorkScope.launch { execution() }
}