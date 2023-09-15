import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import presentation.screens.AdminHome
import kotlin.system.exitProcess

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kt-pub Admin",
        resizable = false,
        state = WindowState(
            size = DpSize(
                width = 1280.dp,
                height = 720.dp
            )
        )
    ) {
        AdminHome(
            closeRequest = {
                exitProcess(0)
            }
        )
    }
}