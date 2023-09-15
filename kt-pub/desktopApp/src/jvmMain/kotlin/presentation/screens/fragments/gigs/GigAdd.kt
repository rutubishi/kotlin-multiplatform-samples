package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import presentation.components.DesktopInput
import presentation.theme.general_padding
import presentation.theme.half_padding

@Composable
fun GigAddView(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(general_padding)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Add Gig",
            style = MaterialTheme.typography.titleLarge,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Role Name")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = half_padding)
            )

            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Employer")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = half_padding)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Role Type")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = half_padding)
            )

            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Role Location (Hybrid, Remote, On-Site)")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = half_padding)
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Salary Range")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = half_padding)
            )

            DesktopInput(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = "Location")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = half_padding)
            )

        }



        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Role Description")
            },
            minLines = 4
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Role Requirements")
            },
            minLines = 4
        )

        DesktopInput(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Benefits / Perks")
            },
            minLines = 4
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
                text = "Add Gig",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(general_padding)
            )
        }

    }

}