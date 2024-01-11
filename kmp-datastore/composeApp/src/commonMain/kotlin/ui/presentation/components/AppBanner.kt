package ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppBanner(
    modifier: Modifier = Modifier,
    isSmallBanner: Boolean = false
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Sharp.ShoppingCart,
            contentDescription = null,
            modifier = Modifier
                .size(if(isSmallBanner) 48.dp else 128.dp)
                .padding(horizontal = if(isSmallBanner) 4.dp else 16.dp)
        )
        Text(
            "Welcome to your shopping list",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = if(isSmallBanner) MaterialTheme.typography.titleMedium else MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }

}