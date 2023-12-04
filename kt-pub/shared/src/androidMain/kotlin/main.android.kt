import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import presentation.screens.client.HomePageSM

actual fun getPlatformName(): String = "Android"

@Composable
@ExperimentalMaterial3Api
fun MainView(
    homePageSM: HomePageSM? = null,
) = App(
    homePageSM = homePageSM
)
