package presentation.screens.fragments.employers

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ScreenSearchDesktop
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import presentation.components.AppLoader
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.standard_icon_size

@Preview
@Composable
fun EmployerList(
    modifier: Modifier = Modifier,
    viewModel: EmployerScreenModel,
) {

    val uiState: EmployerSearchUiState by viewModel.searchUiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = half_padding),
    ) {

        Text(
            text = "Employers",
            style = MaterialTheme.typography.titleLarge,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp)
        )

        OutlinedTextField(
            modifier = Modifier
                .width(350.dp)
                .padding(top = 20.dp),
            value = uiState.searchTerm,
            onValueChange = {
                viewModel.handleSearchActions(EmployerSearchActions.SearchChange(it))
            },
            shape = RoundedCornerShape(50.dp),
            placeholder = {
                Text("Search")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ScreenSearchDesktop,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(half_padding)
                        .size(standard_icon_size / 2)
                        .clickable { viewModel.handleSearchActions(EmployerSearchActions.SubmitSearch) }
                )
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