import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

@Composable
@ExperimentalMaterial3Api
fun MainView() = App()
