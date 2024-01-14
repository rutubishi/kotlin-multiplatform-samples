package ui.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.DarkMode
import androidx.compose.material.icons.sharp.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListSection(
    modifier: Modifier = Modifier,
    showBanner: Boolean = true,
    changeTheme: () -> Unit = {},
    isDark: Boolean = false
) {

    Column(
        modifier = modifier
    ) {
        // show banner on small screen
        if(showBanner){
            AppBanner(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                isSmallBanner = true
            )
        }

        Icon(
            imageVector = if(!isDark) Icons.Sharp.DarkMode else Icons.Sharp.LightMode,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clickable{ changeTheme() }
                .padding(8.dp)
                .align(Alignment.End),
            tint = MaterialTheme.colorScheme.onSurface
        )

        // shopping list
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items((1..10).toList()){
                ShoppingItem(
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // clear section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
        ) {
            Text(
                "Clear Shopping List",
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Light
            )

            Text(
                "Clear Completed",
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Light
            )
        }

    }


}