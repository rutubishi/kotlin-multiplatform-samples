package ui.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListSection(
    modifier: Modifier = Modifier,
    showBanner: Boolean = true
) {

    Column(
        modifier = modifier
    ) {
        // show banner on small screen
        if(showBanner){
            AppBanner(
                modifier = Modifier.fillMaxWidth()
            )
        }

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