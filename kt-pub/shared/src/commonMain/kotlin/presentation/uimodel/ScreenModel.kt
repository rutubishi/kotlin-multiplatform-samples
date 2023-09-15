package presentation.uimodel

import kotlinx.coroutines.CoroutineScope

abstract class ScreenModel {
    abstract val asyncWorkScope:CoroutineScope
}