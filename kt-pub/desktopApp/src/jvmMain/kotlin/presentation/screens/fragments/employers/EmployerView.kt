package presentation.screens.fragments.employers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmployerView(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        EmployerAddView(
            modifier = Modifier
                .weight(1f)
        )
        EmployerList(
            modifier = Modifier
                .weight(1f)
        )
    }

}