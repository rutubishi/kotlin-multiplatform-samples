package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import presentation.components.AppLoader
import presentation.theme.general_padding
import presentation.theme.half_padding

@Composable
fun GigList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = half_padding),
    ) {

        Text(
            text = "Gigs",
            style = MaterialTheme.typography.titleLarge,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp)
        )

        OutlinedTextField(
            modifier = Modifier
                .width(350.dp)
                .padding(top = 20.dp),
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(50.dp),
            placeholder = {
                Text("Search")
            }
        )

        // Lazy Column goes here
        Box(modifier = Modifier
            .fillMaxSize()) {
            AppLoader(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }


    }
}