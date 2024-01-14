import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ui.presentation.App

fun main() = application {

    DataStoreAppComponent.init()

    Window(onCloseRequest = ::exitApplication, title = "kmp-datastore",
        state = WindowState(size = DpSize(1200.dp,1000.dp)), resizable = false) {

        App(
            isWideScreen = true
        )

        LaunchedEffect(true){
            withContext(Dispatchers.IO){
                val dark = coreComponent.themePreference.isInDarkMode()
                println("Is Dark Mode: $dark")
            }
        }


    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}