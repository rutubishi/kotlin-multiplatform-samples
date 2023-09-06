package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.standard_icon_size

@Composable
@ExperimentalMaterial3Api
fun JobTile(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(half_padding)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = general_padding, horizontal = half_padding)
            ) {

                Icon(
                    imageVector = Icons.Filled.Games,
                    contentDescription = null,
                    modifier = Modifier
                        .size(standard_icon_size / 2)
                )

                Column(
                    modifier = Modifier
                        .padding(start = half_padding),
                    verticalArrangement = Arrangement.SpaceAround
                ) {

                    Text(
                        text = "Game Designer",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Google Inc. California, USA",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )

                }

                Icon(
                    imageVector = Icons.Outlined.BookmarkAdd,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = standard_icon_size)
                        .size(standard_icon_size / 3)
                )

            }

            Text(
                modifier = Modifier.padding(horizontal = half_padding),
                text = buildAnnotatedString {
                    withStyle(SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,

                    )){
                        append("$180-195k ")
                    }
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Light,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ){
                        append("/ year")
                    }
                }
            )

            Row {
                JobCatFilter(
                    title = "Intermediate",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Anchor,
                            contentDescription = null
                        )
                    },
                    backgroundColor = MaterialTheme.colorScheme.tertiary,
                    surfaceColor = MaterialTheme.colorScheme.onTertiary
                )

                JobCatFilter(
                    title = "Hybrid",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Computer,
                            contentDescription = null
                        )
                    },
                    backgroundColor = MaterialTheme.colorScheme.secondary,
                    surfaceColor = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.padding(start = half_padding)
                )

            }

        }

    }
}


@Composable
@ExperimentalMaterial3Api
fun JobCatFilter(
    leadingIcon: @Composable () -> Unit = {},
    backgroundColor: Color,
    surfaceColor: Color,
    title: String,
    selected: Boolean = true,
    onSelect: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    InputChip(
        modifier = modifier,
        selected = selected,
        onClick = onSelect,
        label = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall
            )
        },
        leadingIcon = leadingIcon,
        colors = InputChipDefaults.inputChipColors(
            selectedContainerColor = backgroundColor,
            selectedLeadingIconColor = surfaceColor,
            selectedLabelColor = surfaceColor
        )
    )

}