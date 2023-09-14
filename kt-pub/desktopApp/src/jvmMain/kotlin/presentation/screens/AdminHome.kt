package presentation.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import presentation.screens.fragments.employers.EmployerAddView
import presentation.theme.general_padding
import presentation.theme.standard_icon_size

@Preview
@Composable
fun AdminHome() {

    val menuOptions = arrayOf(
        mapOf("title" to "Home", "icon" to Icons.Filled.Home),
        mapOf("title" to "Gigs", "icon" to Icons.Filled.Work),
        mapOf("title" to "Employers", "icon" to Icons.Filled.AccountCircle)
    )

    Row(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        NavigationRail(modifier = Modifier
            .fillMaxHeight()
            .width(150.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)){

            menuOptions.forEach {
                val icon: ImageVector by it
                val title: String by it
                NavItem(
                    title = title,
                    icon = icon
                )
            }
        }

        // View employer
        EmployerAddView()

    }


}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    title: String = "",
    icon: ImageVector = Icons.Filled.Home,
    onSelectMenu: () -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = general_padding)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(),
                onClick = onSelectMenu
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(standard_icon_size)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.ExtraBold,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp)
        )
    }

}