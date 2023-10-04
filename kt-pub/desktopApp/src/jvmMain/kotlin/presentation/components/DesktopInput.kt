package presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.theme.half_padding

@Composable
fun DesktopInput(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    leadingIcon: (@Composable () -> Unit)? = null,
    minLines: Int = 1,
    enabled: Boolean = true
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(half_padding),
        value = value,
        onValueChange = { onValueChange(it) },
        label = placeholder,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        minLines = minLines,
        enabled = enabled
    )
}