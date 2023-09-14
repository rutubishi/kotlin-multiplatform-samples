import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import presentation.screens.AdminHome

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kt-pub Admin",
        resizable = false,
        state = WindowState(
            placement = WindowPlacement.Maximized
        )
    ) {
        AdminHome()
    }
}