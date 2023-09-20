package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.defaultImageResultMemoryCache
import okio.Path.Companion.toOkioPath
import java.io.File

actual fun appImageLoader(): ImageLoader {
    return ImageLoader {
        components {
            setupDefaultComponents()
        }
        interceptor {
            // cache 100 success image result, without bitmap
            defaultImageResultMemoryCache()
            memoryCacheConfig {
                maxSizeBytes(32 * 1024 * 1024) // 32MB
            }
            diskCacheConfig {
                directory(getCacheDir().toOkioPath().resolve("image_cache"))
                maxSizeBytes(512L * 1024 * 1024) // 512MB
            }
        }
    }
}

// about currentOperatingSystem, see app
private fun getCacheDir() = when (currentOperatingSystem) {
    OperatingSystem.Windows -> File(System.getenv("AppData"), "kt-pub/cache")
    OperatingSystem.Linux -> File(System.getProperty("user.home"), ".cache/kt-pub")
    OperatingSystem.MacOS -> File(System.getProperty("user.home"), "Library/Caches/kt-pub")
    else -> throw IllegalStateException("Unsupported operating system")
}

enum class OperatingSystem {
    Windows, Linux, MacOS, Unknown
}

private val currentOperatingSystem: OperatingSystem
    get() {
        val operSys = System.getProperty("os.name").lowercase()
        return if (operSys.contains("win")) {
            OperatingSystem.Windows
        } else if (operSys.contains("nix") || operSys.contains("nux") ||
            operSys.contains("aix")
        ) {
            OperatingSystem.Linux
        } else if (operSys.contains("mac")) {
            OperatingSystem.MacOS
        } else {
            OperatingSystem.Unknown
        }
    }

@Composable
actual fun AppImage(painter: Painter) {
    CompositionLocalProvider(
        LocalImageLoader provides remember { appImageLoader() }
    ){
        Image(painter = painter, contentDescription = null)
    }
}

@Composable
fun DesktopImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String? = null
) {
    CompositionLocalProvider( LocalImageLoader provides remember { appImageLoader() }){
        Image(
            modifier = modifier,
            painter = painter,
            contentDescription = contentDescription
        )
    }
}