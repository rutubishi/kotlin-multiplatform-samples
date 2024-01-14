package ui.presentation

import Greeting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material.icons.sharp.DarkMode
import androidx.compose.material.icons.sharp.LightMode
import androidx.compose.material.icons.sharp.ShieldMoon
import androidx.compose.material3.*
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
    isWideScreen: Boolean = true,
) {

    val systemDark = isSystemInDarkTheme()
    var isDark: Boolean by remember { mutableStateOf(systemDark) }

    AppTheme(
        useDarkTheme = isDark
    ) {

        Surface {

            if (isWideScreen) {

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
                        showBanner = false,
                        changeTheme = { isDark = !isDark  },
                        isDark = isDark
                    )

                }
            } else {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    ShoppingListSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        showBanner = true,
                        changeTheme = { isDark = !isDark  },
                        isDark = isDark
                    )

                    InputShoppingItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .padding(top = 8.dp)
                            .align(Alignment.BottomCenter)
                    )

                }

            }
        }

    }
}


