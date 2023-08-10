package com.rutubishi.calculatorkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rutubishi.calculatorkmp.common.ui.presentation.screens.AppScreen
import com.rutubishi.calculatorkmp.common.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppScreen()
            }
        }
    }
}

@Preview
@Composable
fun AppPreview(){
    AppTheme {
        AppScreen()
    }
}