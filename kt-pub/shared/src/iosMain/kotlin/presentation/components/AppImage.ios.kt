package presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.seiko.imageloader.ImageLoader

actual fun appImageLoader(): ImageLoader {
    return ImageLoader {  }
}

@Composable
actual fun AppImage(painter: Painter) {
}