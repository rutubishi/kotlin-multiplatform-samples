import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.rutubishi.kmpdatastore.core_data.datasource.buildThemeDataSource
import com.rutubishi.kmpdatastore.core_data.repository.ThemeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ui.presentation.App
import ui.presentation.AppViewModel

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val appViewModel = AppViewModel(
            themeRepo = ThemeRepository(themeDataSource = buildThemeDataSource()),
            coroutineScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())
        )
        App(
            viewModel =  appViewModel
        )
    }
}