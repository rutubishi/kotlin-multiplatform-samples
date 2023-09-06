package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.theme.general_padding

@Composable
fun AppNavBar(
    leadElement: @Composable () -> Unit = {},
    endElement: @Composable () -> Unit = {},
    isWideScreen: Boolean = false,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = general_padding),
        horizontalArrangement = if(isWideScreen) Arrangement.Start else Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        leadElement()
        endElement()
    }

}