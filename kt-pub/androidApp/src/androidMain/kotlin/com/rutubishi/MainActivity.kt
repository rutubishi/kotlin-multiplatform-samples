package com.rutubishi

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import data.network.repositories.GigsRepoImpl
import presentation.screens.HomePageSMAndroid

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nativeHomePage = HomePageSMAndroid(
            GigsRepoImpl()
        )

        setContent {
            MainView(
                homePageSM = nativeHomePage.screen
            )
        }
    }
}