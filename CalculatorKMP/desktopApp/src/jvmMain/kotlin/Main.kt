import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.rutubishi.calculatorkmp.common.ui.presentation.screens.AppScreen
import com.rutubishi.calculatorkmp.common.ui.theme.AppTheme


@ExperimentalMaterial3Api
fun main() = application {
    Window(
        icon = painterResource("calculator.png"),
        title = "CalculatorKMP",
        onCloseRequest = ::exitApplication,
        state = WindowState(
            size = DpSize(width = 600.dp, height = 900.dp)
        ),
        resizable = false
    ){

        AppTheme {
            AppScreen()
        }

    }
}