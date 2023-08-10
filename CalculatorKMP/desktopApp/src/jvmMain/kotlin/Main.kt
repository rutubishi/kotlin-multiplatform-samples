import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rutubishi.calculatorkmp.common.ui.presentation.screens.AppScreen
import com.rutubishi.calculatorkmp.common.ui.theme.AppTheme


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication
    ){

        AppTheme {
            AppScreen()
        }

    }
}