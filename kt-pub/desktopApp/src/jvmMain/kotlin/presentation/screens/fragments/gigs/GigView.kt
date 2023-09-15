package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GigView(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        GigAddView(
            modifier = Modifier
                .weight(1f)
        )

        GigList(
            modifier = Modifier
                .weight(1f)
        )
    }
}