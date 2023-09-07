package presentation.screens.client

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DesktopMac
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import presentation.components.AppHeader
import presentation.components.AppNavBar
import presentation.components.JobSummary
import presentation.components.JobTile
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
    Column {
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
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = half_padding)
    ) {

        AppHeader(
            header = "Recently listed jobs"
        )

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = half_padding),
        ) {

            items(arrayListOf("hello")) {
                JobTile()
            }

        }

    }

}


@Composable
@ExperimentalMaterial3Api
fun HomePage(
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        JobStatsSection()
        JobsRecentSection()
    }

}