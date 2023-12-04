import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import presentation.components.AppHeader
import presentation.components.BottomNavBar
import presentation.screens.client.HomeAppBar
import presentation.screens.client.HomePage
import presentation.screens.client.HomePageSM
import presentation.theme.KtPubTheme
import presentation.theme.half_padding

@Composable
@ExperimentalMaterial3Api
fun App(
    homePageSM: HomePageSM? = null
) {
    KtPubTheme {
        Scaffold(
            topBar = {
                HomeAppBar()
            },
            contentWindowInsets = WindowInsets(
                left = half_padding,
                right = half_padding,
            ),
            bottomBar = {
                BottomNavBar()
            }
        ) { padding ->

            HomePage(
                homePageSM = homePageSM,
                modifier = Modifier
                    .padding(padding)
            )

        }
    }
}

expect fun getPlatformName(): String