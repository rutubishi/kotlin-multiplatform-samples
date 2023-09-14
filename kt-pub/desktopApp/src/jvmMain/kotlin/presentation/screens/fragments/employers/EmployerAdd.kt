package presentation.screens.fragments.employers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.components.DesktopInput
import presentation.theme.general_padding
import presentation.theme.half_padding

@Composable
fun EmployerAddView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = half_padding),
    ) {

        Text(
            text = "Add Employer",
            style = MaterialTheme.typography.titleLarge
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Logo URL")
            }
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Employer Details")
            },
            minLines = 4
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Webpage")
            }
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Industry (Education, Hospitality etc.)")
            }
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Company Size")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }
        )

        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = half_padding),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ){
            Text(
                text = "Add Employer",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(general_padding)
            )
        }

        // CompanySizeDropdown()

    }
}

@Composable
fun CompanySizeDropdown() {
    var isExpanded by remember { mutableStateOf(true) }
    val sizes = arrayOf(
        "SMALL", "MEDIUM", "LARGE", "MULTINATIONAL"
    )
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(half_padding)
    ){
        sizes.forEach {
            DropdownMenuItem(
                onClick = {},
            ){
                Text(text = it)
            }
        }
    }
}

