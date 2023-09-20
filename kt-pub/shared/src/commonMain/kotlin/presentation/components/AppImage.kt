package presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.seiko.imageloader.ImageLoader

@Composable
expect fun AppImage(painter: Painter)
expect fun appImageLoader(): ImageLoader