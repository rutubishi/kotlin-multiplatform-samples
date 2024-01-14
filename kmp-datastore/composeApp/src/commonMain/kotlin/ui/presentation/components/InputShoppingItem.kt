package ui.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.presentation.AppViewModel

@Composable
fun InputShoppingItem(
    modifier: Modifier = Modifier
) {

    var input by remember { mutableStateOf("") }

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = input,
            onValueChange = { text ->  input = text},
            modifier = Modifier.weight(4f).padding(4.dp),
            label = {
                Text("Add a shopping item")
            },
        )

        FloatingActionButton(
            onClick = {  },
            modifier = Modifier
                .padding(4.dp),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            shape = CircleShape
        ){
            Icon(
                imageVector = Icons.Sharp.Add,
                contentDescription = "Add",
            )
        }

    }

}