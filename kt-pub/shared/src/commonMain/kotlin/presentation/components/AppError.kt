package presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NearbyError
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.theme.standard_icon_size

@Composable
fun AppError(
    message: String,
    modifier: Modifier = Modifier,
    errorImage: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Filled.NearbyError,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )
    },
    customMessage: (@Composable () -> Unit)? = null
) {

    Box(
        modifier = modifier
            .size(200.dp)
    ) {
        Dialog(
            onDismissRequest = {

            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                errorImage()
                customMessage?.invoke() ?: Text(
                    text = message,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.error
                )
            }

        }
    }
}


@Composable
fun AppErrorCard(
    message: String,
    modifier: Modifier = Modifier,
    errorImage: @Composable () -> Unit = {
        Icon(
            modifier = Modifier.size(standard_icon_size),
            imageVector = Icons.Filled.NearbyError,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )
    },
    customMessage: (@Composable () -> Unit)? = null
) {

    ElevatedCard(
        modifier = modifier
            .padding(horizontal = half_padding)
            .padding(top = half_padding)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = general_padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            errorImage()
            customMessage?.invoke() ?: Text(
                text = message,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

