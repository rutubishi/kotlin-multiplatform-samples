package presentation.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import presentation.screens.fragments.employers.EmployerScreenModel
import presentation.screens.fragments.employers.EmployerView
import presentation.screens.fragments.gigs.GigScreenModel
import presentation.screens.fragments.gigs.GigView
import presentation.screens.fragments.home.HomeView
import presentation.theme.general_padding
import presentation.theme.standard_icon_size

@Preview
@Composable
fun AdminHome(
    closeRequest: () -> Unit = {},
    adminScreenModel: AdminScreenModel,
    employerScreenModel: EmployerScreenModel,
    gigScreenModel: GigScreenModel
) {
    val screenUiState: AdminUiState by adminScreenModel.currentPage.collectAsState()
    val menuOptions = arrayOf(
        mapOf("title" to "Home", "icon" to Icons.Filled.Home, "screen" to AdminScreen.HomeScreen),
        mapOf("title" to "Gigs", "icon" to Icons.Filled.Work, "screen" to AdminScreen.GigScreen()),
        mapOf("title" to "Employers", "icon" to Icons.Filled.AccountCircle, "screen" to AdminScreen.EmployerScreen)
    )

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            NavigationRail(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(125.dp),
            ){

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {

                        menuOptions.forEachIndexed { _, map ->

                            val icon: ImageVector by map
                            val title: String by map
                            val screen: AdminScreen by map

                            NavItem(
                                title = title,
                                icon = icon,
                                selectedScreen = screen,
                                onSelectMenu = { adminScreen ->
                                    adminScreenModel.handleNavigation(
                                        actions = when(adminScreen){
                                            AdminScreen.EmployerScreen -> AdminNavigationActions.NavigateToEmployer
                                            is AdminScreen.GigScreen -> AdminNavigationActions.NavigateToGig(0L)
                                            AdminScreen.HomeScreen -> AdminNavigationActions.NavigateToHome
                                            null -> AdminNavigationActions.NavigateToHome
                                        }
                                    )
                                },
                                selected = screenUiState.currentScreen == screen
                            )
                        }

                    }

                    NavItem(
                        title = "Log Out",
                        icon = Icons.Filled.Logout,
                        onSelectMenu = {
                            closeRequest()
                        }
                    )

                }


            }

            // screens
            when(screenUiState.currentScreen){
                is AdminScreen.HomeScreen -> HomeView()
                is AdminScreen.EmployerScreen -> EmployerView(
                    adminScreenModel = adminScreenModel,
                    employerScreenModel = employerScreenModel
                )
                is AdminScreen.GigScreen -> GigView(
                    employerId = (screenUiState.currentScreen as AdminScreen.GigScreen).employerId,
                    gigScreenModel = gigScreenModel
                )
            }

        }
    }


}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    title: String = "",
    icon: ImageVector = Icons.Filled.Home,
    onSelectMenu: (AdminScreen?) -> Unit = {},
    selectedScreen: AdminScreen? = null,
    selected: Boolean = false
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = general_padding * 2)
            .background(color = Color.Transparent, shape = CircleShape)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(),
                onClick = {
                    onSelectMenu(selectedScreen)
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(standard_icon_size / 2),
            tint = if(selected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(value = 15f, TextUnitType.Sp),
            color = if(selected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onPrimaryContainer
        )
    }

}