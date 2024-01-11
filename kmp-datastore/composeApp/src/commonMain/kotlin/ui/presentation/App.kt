package ui.presentation

import Greeting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.presentation.components.AppBanner
import ui.presentation.components.InputShoppingItem
import ui.presentation.components.ShoppingItem
import ui.presentation.components.ShoppingListSection
import ui.theme.AppTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    isWideScreen: Boolean = true
) {
    AppTheme {

        if(isWideScreen){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(128.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    AppBanner(
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    InputShoppingItem(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                ShoppingListSection(
                    modifier = Modifier.weight(1f),
                    showBanner = false
                )

            }
        } else {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {

                ShoppingListSection(
                    showBanner = true
                )

                InputShoppingItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )

            }

        }

    }
}


