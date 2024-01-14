import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.rutubishi.kmpdatastore.core_data.datasource.buildThemeDataSource
import com.rutubishi.kmpdatastore.core_data.repository.ThemeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ui.presentation.App
import ui.presentation.AppViewModel

fun main() = application {

    DataStoreAppComponent.init()

    val appViewModel = AppViewModel(
        themeRepo = ThemeRepository(themeDataSource = buildThemeDataSource()),
        coroutineScope = CoroutineScope(Dispatchers.IO)
    )

    Window(onCloseRequest = ::exitApplication, title = "kmp-datastore",
        state = WindowState(size = DpSize(1200.dp,1000.dp)), resizable = false) {

        App(
            isWideScreen = true,
            viewModel = appViewModel
        )



    }
}

@Preview
@Composable
fun AppDesktopPreview() {

}