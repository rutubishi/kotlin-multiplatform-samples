package presentation.screens.fragments.employers

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person4
import androidx.compose.material.icons.filled.ScreenSearchDesktop
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
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
import data.network.EmployerDto
import presentation.components.AppLoader
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.standard_icon_size
import presentation.uimodel.ScreenState

@Preview
@Composable
fun EmployerList(
    modifier: Modifier = Modifier,
    viewModel: EmployerScreenModel,
) {

    val uiState: EmployerSearchUiState by viewModel.searchUiState.collectAsState()
    val searchState: ScreenState<String?> by viewModel.searchState.collectAsState()

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

        when(searchState){
            is ScreenState.Error -> EmployerLoader()
            is ScreenState.Idle -> EmployerLoader()
            is ScreenState.Loading -> EmployerLoader()
            is ScreenState.Success -> {
                EmployerSearchList(uiState.searchResults)
            }
        }

    }
}

@Composable
fun EmployerLoader() {
    Box(modifier = Modifier
        .fillMaxSize()) {
        AppLoader(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun EmployerSearchList(
    employers: List<EmployerDto>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = half_padding),
        verticalArrangement = Arrangement.spacedBy(half_padding)
    ) {

        items(employers){
            EmployerSearchResult(employer = it)
        }

    }
}

@Composable
fun EmployerSearchResult(
    employer: EmployerDto
) {

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(half_padding),
        ) {

            Icon(
                imageVector = Icons.Default.Person4,
                contentDescription = null,
                modifier = Modifier.size(standard_icon_size))
            Column(
                modifier = Modifier.fillMaxSize().padding(start = general_padding),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = employer.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = employer.industry,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )

            }
        }

    }

}
