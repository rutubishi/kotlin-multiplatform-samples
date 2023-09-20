package presentation.uimodel

/**
 * Model Screen States
 * */
sealed class ScreenState <T>(
    val message: String? = null,
    val data: T? = null
){
    class Success<T>(data: T): ScreenState<T>(data = data)
    class Loading<T>(data: T? = null) : ScreenState<T>(data = data)
    class Error<T>(message: String): ScreenState<T>(message = message)
    class Idle<T>(data: T) : ScreenState<T>(data = data)
}