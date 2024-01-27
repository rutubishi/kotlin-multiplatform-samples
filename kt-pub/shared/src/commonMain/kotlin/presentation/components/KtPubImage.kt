package presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.kamel.core.Resource
import io.kamel.core.config.DefaultCacheSize
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.ktor.client.plugins.defaultRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

val ktPubKamelConfig = KamelConfig {
    takeFrom(KamelConfig.Default)
    imageBitmapCacheSize = DefaultCacheSize
    httpFetcher {
        httpCache(DefaultCacheSize.toLong())
    }
}

@Composable
fun KtPubImage(
    model: String,
    contentDescription: String? = null,
    alignment: Alignment? = null,
    contentScale: ContentScale? = null,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    modifier: Modifier = Modifier
) {

    CompositionLocalProvider(LocalKamelConfig provides ktPubKamelConfig){
        val painterResource: Resource<Painter> = asyncPainterResource(data = model)
        { coroutineContext = Job() + coroutineDispatcher }

        println("resource $painterResource")

        KamelImage(
            resource = painterResource,
            contentDescription = contentDescription,
            modifier = modifier,
            alignment = alignment ?: Alignment.Center,
            contentScale = contentScale ?: ContentScale.Crop,
            onLoading = { progress ->
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(2.dp),
                    progress = progress
                )
            },
            onFailure = {
                Text(
                    text = "Error!!",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall
                )
            },
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    }
}