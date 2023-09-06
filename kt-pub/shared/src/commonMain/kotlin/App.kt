import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import presentation.components.AppHeader
import presentation.screens.client.HomeAppBar
import presentation.screens.client.HomePage
import presentation.theme.KtPubTheme
import presentation.theme.half_padding

@Composable
fun App() {
    KtPubTheme {
        Scaffold(
            topBar = {
                HomeAppBar()
            },
            contentWindowInsets = WindowInsets(
                left = half_padding,
                right = half_padding,
            )
        ) { padding ->

            HomePage(
                modifier = Modifier
                    .padding(padding)
            )

        }
    }
}

expect fun getPlatformName(): String