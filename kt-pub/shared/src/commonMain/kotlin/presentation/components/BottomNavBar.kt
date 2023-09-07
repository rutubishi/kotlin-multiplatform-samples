package presentation.components

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import presentation.theme.standard_icon_size

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {

    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .height(standard_icon_size),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = null,
            modifier = Modifier.size(standard_icon_size / 2),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier
                .size(standard_icon_size / 2)
                .clip(CircleShape),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Icon(
            imageVector = Icons.Filled.BookmarkAdded,
            contentDescription = null,
            modifier = Modifier.size(standard_icon_size / 2),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )

    }

}