import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun MainView() = App()

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppPreview() {
    App()
}