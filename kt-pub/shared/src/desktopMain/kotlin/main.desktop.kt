import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import data.network.repositories.GigsRepoImpl
import presentation.screens.client.HomePageSM

actual fun getPlatformName(): String = "Desktop"

class DummyHomePage: HomePageSM(gigsRepository = GigsRepoImpl())

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun MainView() = App(DummyHomePage())

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppPreview() {
    App(DummyHomePage())
}