package presentation.screens.fragments.employers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import presentation.components.DesktopInput
import presentation.theme.general_padding
import presentation.theme.half_padding

@Composable
fun EmployerAddView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = general_padding),
    ) {

        var companyDropdownMenuShown by remember { mutableStateOf(false) }
        var companySize by remember { mutableStateOf("") }

        Text(
            text = "Add Employer",
            style = MaterialTheme.typography.titleLarge,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp)
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
            value = companySize,
            onValueChange = {},
            placeholder = {
                Text(text = "Company Size")
            },
            trailingIcon = {
                Icon(
                    imageVector = if (companyDropdownMenuShown) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(),
                        onClick = { companyDropdownMenuShown = !companyDropdownMenuShown }
                    )
                )
            }
        )

        CompanySizeDropdown(
            modifier = Modifier.align(Alignment.End),
            isExpanded = companyDropdownMenuShown
        ){ itemSelected ->
            companySize = itemSelected
            companyDropdownMenuShown = false
        }

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Employer Details")
            },
            minLines = 6
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

    }
}

@Composable
fun CompanySizeDropdown(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onItemClick: (String) -> Unit = {}
) {
    val sizes = arrayOf("SMALL", "MEDIUM", "LARGE", "MULTINATIONAL")
    Box(
        modifier = modifier
            .width(200.dp)
    ) {
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { },
            modifier = Modifier
                .padding(horizontal = half_padding),
            properties = PopupProperties(
                clippingEnabled = true,
                dismissOnClickOutside = true
            )
        ){
            sizes.forEach {
                DropdownMenuItem(
                    onClick = { onItemClick(it) },
                ){
                    Text(text = it)
                }
            }
        }
    }

}

