import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import presentation.screens.AdminHome
import presentation.screens.fragments.AdminScreenModel
import kotlin.system.exitProcess

fun main() = application {
    val screenModel = AdminScreenModel()
    Window(
        onCloseRequest = ::exitApplication,
        title = "kt-pub Admin",
        resizable = false,
        state = WindowState(
            size = DpSize(
                width = 1280.dp,
                height = 1080.dp
            )
        )
    ) {
        AdminHome(
            closeRequest = {
                exitProcess(0)
            },
            adminScreenModel = screenModel
        )
    }
}