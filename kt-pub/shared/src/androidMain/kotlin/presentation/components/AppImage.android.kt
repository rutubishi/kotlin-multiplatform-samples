package presentation.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.cache.memory.maxSizePercent
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.defaultImageResultMemoryCache
import com.seiko.imageloader.option.androidContext
import okio.Path.Companion.toOkioPath

actual fun appImageLoader(): ImageLoader {
    return androidAppImageLoader()
}

fun androidAppImageLoader(appContext: Context? = null): ImageLoader {
    return ImageLoader{
        options {
            androidContext(appContext!!)
        }
        components {
            setupDefaultComponents()
        }
        interceptor {
            defaultImageResultMemoryCache()
            memoryCacheConfig {
                maxSizePercent(appContext!!, 0.25)
            }
            diskCacheConfig {
                directory(appContext!!.cacheDir.resolve("image_cache").toOkioPath())
                maxSizeBytes(512 * 1024 * 1024)
            }
        }
    }
}

@Composable
actual fun AppImage(painter: Painter) {
}