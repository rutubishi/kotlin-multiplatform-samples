package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import data.network.GigResponse
import presentation.components.AppLoader
import presentation.components.DesktopImage
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.standard_icon_size
import presentation.uimodel.ScreenState

@Composable
fun GigList(
    modifier: Modifier = Modifier,
    gigSearchUiState: GigSearchUiState,
    gigSearchScreenState: ScreenState<String>,
    isWideScreen: Boolean = false
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


        Box(modifier = Modifier
            .fillMaxSize()) {

            if(gigSearchUiState.searchResults.isEmpty()){
                AppLoader(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }else {

                if(isWideScreen){
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        items(gigSearchUiState.searchResults){
                            GigSearchResult(it)
                        }
                    }
                }else{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = general_padding, horizontal = half_padding),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(gigSearchUiState.searchResults) {
                            GigSearchResult(it)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun GigSearchResult(
    gigResponse: GigResponse,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(standard_icon_size * 2)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp)
        ) {
            DesktopImage(
                painter = rememberImagePainter(gigResponse.employerLogo),
                contentDescription = gigResponse.description,
                modifier = Modifier.fillMaxHeight().width(standard_icon_size)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp, end = 8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Text(text = gigResponse.title, style = MaterialTheme.typography.bodyLarge)
                Text(text = gigResponse.employer, style = MaterialTheme.typography.bodyMedium)
                Text(text = gigResponse.location, style = MaterialTheme.typography.labelLarge)
                Text(text = gigResponse.roleType, style = MaterialTheme.typography.labelMedium)


            }
        }

    }
}