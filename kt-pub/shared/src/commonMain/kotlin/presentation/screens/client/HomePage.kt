package presentation.screens.client

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DesktopMac
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import data.network.AppResource
import presentation.components.*
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.med_text_size
import presentation.theme.standard_icon_size

@Composable
fun HomeAppBar(
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {
    AppNavBar(
        leadElement = {
            Text(
                text = "Hello there,\nWelcome to kt-pub",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                fontSize = med_text_size,
                color = MaterialTheme.colorScheme.primary
            )
        },
        endElement = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(standard_icon_size)
            )
        },
        isWideScreen = isWideScreen,
        modifier = modifier
    )
}


@Composable
fun JobStatsSection() {
    Column(
        modifier = Modifier
            .padding(top = half_padding)
    ) {
        /**
         * Section header
         * */
        AppHeader(
            annotatedHeader = buildAnnotatedString {
                append("Grab your next ")
                withStyle(
                    style = SpanStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Red)
                        )
                    )
                ){
                    append("#kotlin ")
                }
                append("gig")
            }
        )
        /**
         * Section header --end
         * */


        /**
         * Job stats cards
         * */
        Row(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            JobSummary(
                backgroundColor = MaterialTheme.colorScheme.primary,
                jobCount = "44.3k",
                jobType = "Remote Jobs",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = half_padding / 2)
                    .weight(1f)
            ){
                Icon(
                    modifier = Modifier.size(standard_icon_size / 2),
                    imageVector = Icons.Filled.DesktopMac,
                    contentDescription = null
                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = half_padding / 2)
            ) {

                JobSummary(
                    backgroundColor = MaterialTheme.colorScheme.secondary,
                    jobCount = "44.3k",
                    jobType = "Hybrid Jobs",
                    modifier = Modifier
                        .padding(bottom = half_padding / 2)
                        .weight(1f)
                )

                JobSummary(
                    backgroundColor = MaterialTheme.colorScheme.tertiary,
                    jobCount = "44.3k",
                    jobType = "On-Site Jobs",
                    modifier = Modifier
                        .padding(top = half_padding / 2)
                        .weight(1f)
                )

            }
        }
        /**
         * Job stats cards --end
         * */
    }
}

@Composable
@ExperimentalMaterial3Api
fun JobsRecentSection(
    homePageUiState: HomePageUiState,
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = general_padding)
    ) {

        AppHeader(
            header = "Recently listed jobs"
        )

        when(homePageUiState.latestGigsState){
            is AppResource.Error -> {
                Text("There was an error")
            }
            is AppResource.Loading -> {
                AppLoader(modifier = Modifier.fillMaxWidth())
            }
            is AppResource.Success -> {
                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = half_padding),
                    horizontalArrangement = Arrangement
                        .spacedBy(half_padding)
                ) {

                    items(homePageUiState.latestGigsState.res?.body?.body ?: emptyList()) {
                        JobTile(jobData = it)
                    }

                }
            }
        }



    }

}

@Composable
fun KotlinNewsBanner(
    modifier: Modifier = Modifier,
    title: String = ""
) {

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = half_padding),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = general_padding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    modifier = Modifier.padding(top = general_padding),
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                ElevatedButton(
                    modifier = Modifier
                        .padding(top = half_padding, bottom = general_padding),
                    onClick =  {

                    },
                ){
                    Text(
                        text = "Learn More",
                    )
                }

            }

            Icon(
                imageVector = Icons.Filled.Newspaper,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(standard_icon_size)
            )

        }

    }

}


@Composable
@ExperimentalMaterial3Api
fun HomePage(
    homePageSM: HomePageSM,
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

    val homePageUiState: HomePageUiState by homePageSM.screenDataState.collectAsState()

    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        KotlinNewsBanner(
            title = "The K2 compiler is now ready!"
        )
        JobStatsSection()
        JobsRecentSection(homePageUiState)
    }

}