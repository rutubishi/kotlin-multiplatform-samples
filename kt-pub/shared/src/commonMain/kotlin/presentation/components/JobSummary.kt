package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import presentation.theme.general_padding
import presentation.theme.half_padding

@Composable
fun JobSummary(
    isExpanded: Boolean = true,
    backgroundColor: Color,
    jobCount: String,
    jobType: String,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = general_padding)
        ) {

            if(isExpanded) icon()

            Text(
                text = jobCount,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = jobType,
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }
}