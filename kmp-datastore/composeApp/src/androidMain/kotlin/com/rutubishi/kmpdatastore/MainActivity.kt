package com.rutubishi.kmpdatastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rutubishi.kmpdatastore.core_data.datasource.buildThemeDataSource
import com.rutubishi.kmpdatastore.core_data.repository.ThemeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ui.presentation.App
import ui.presentation.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appViewModel = AppViewModel(
            themeRepo = ThemeRepository(themeDataSource = buildThemeDataSource()),
            coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )

        setContent {
            App(
                isWideScreen = false,
                viewModel = appViewModel
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val appViewModel = AppViewModel(
        themeRepo = ThemeRepository(themeDataSource = buildThemeDataSource()),
        coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    )

    App(viewModel = appViewModel)
}