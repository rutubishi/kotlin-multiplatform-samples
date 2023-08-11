package com.rutubishi.calculatorkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rutubishi.calculatorkmp.common.ui.presentation.screens.AppScreen
import com.rutubishi.calculatorkmp.common.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
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
@ExperimentalMaterial3Api
fun AppPreview(){
    AppTheme {
        AppScreen()
    }
}