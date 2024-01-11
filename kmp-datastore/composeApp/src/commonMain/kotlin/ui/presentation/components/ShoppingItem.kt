package ui.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingItem(
    modifier: Modifier = Modifier
) {

    var selected by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = if(selected)
                MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = {
            selected = !selected
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = selected,
                onCheckedChange = { checked -> selected = checked },
                modifier = Modifier
                    .size(48.dp)
            )

            Text(
                "Kales",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if(selected) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 4.dp)
            )

            Text(
                "6pcs",
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = if(selected) FontWeight.Bold else FontWeight.Light,
                modifier = Modifier
                    .weight(5f)
                    .padding(end = 8.dp)
            )

        }
    }

}