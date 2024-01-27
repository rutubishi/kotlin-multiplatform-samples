package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HomeMax
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import presentation.conditional
import presentation.theme.standard_icon_size

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
) {

    var selectedItem: Int  by remember { mutableStateOf(0) }

    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .height(standard_icon_size),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        BottomNavItem(
            icon = Icons.Filled.Home,
            selected = selectedItem == 0,
            clicked = {
                selectedItem = 0
            }
        )

        BottomNavItem(
            icon = Icons.Filled.Search,
            selected = selectedItem == 1,
            clicked = {
                selectedItem = 1
            }
        )

        BottomNavItem(
            icon = Icons.Filled.BookmarkAdded,
            selected = selectedItem == 2,
            clicked = {
                selectedItem = 2
            }
        )

//        Icon(
//            imageVector = Icons.Filled.Home,
//            contentDescription = null,
//            modifier = Modifier.size(standard_icon_size / 2),
//            tint = MaterialTheme.colorScheme.onPrimaryContainer
//        )
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null,
//            modifier = Modifier
//                .size(standard_icon_size / 2)
//                .clip(CircleShape),
//            tint = MaterialTheme.colorScheme.onPrimaryContainer
//        )
//
//        Icon(
//            imageVector = Icons.Filled.BookmarkAdded,
//            contentDescription = null,
//            modifier = Modifier.size(standard_icon_size / 2),
//            tint = MaterialTheme.colorScheme.onPrimaryContainer
//        )

    }

}


@Composable
fun BottomNavItem(
    selected: Boolean = false,
    icon: ImageVector,
    contentDescription: String? = null,
    iconIndex: Int = 0,
    modifier: Modifier = Modifier,
    clicked: (Int) -> Unit,
) {

    Icon(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .conditional(
                condition = selected,
                ifTrue = {
                    background(color =  MaterialTheme.colorScheme.tertiary, shape = CircleShape).
                    padding(all = 8.dp)
                },
                ifFalse = {
                   padding(all = 0.dp)
                })
            .size(standard_icon_size / 2)
            .clickable { clicked(iconIndex) },
        tint = if(!selected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onTertiary
    )

}