package com.rutubishi.calculatorkmp.common.ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun FunctionKey(
    value: Char = '+',
    modifier: Modifier = Modifier,
    content: (@Composable () -> Unit)? = null,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(75.dp)
            .clipToBounds()
            .background(
                color = MaterialTheme.colorScheme.surface,
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        if(content == null){
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = value.toString(),
                style = MaterialTheme.typography.displaySmall
            )
        }else{
            content()
        }
    }

}


@Composable
fun NumberKey(
    value: Char = '1',
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Box(
        modifier = modifier
            .size(75.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .padding(5.dp),
            text = value.toString(),
            style = MaterialTheme.typography.displaySmall
        )
    }
}


@Composable
fun SubmitCalculation(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(5.dp)
    ){
        Text(text = "=", style = MaterialTheme.typography.displayMedium)
    }
}
