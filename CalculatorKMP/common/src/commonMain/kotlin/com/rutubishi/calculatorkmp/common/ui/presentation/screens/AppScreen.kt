package com.rutubishi.calculatorkmp.common.ui.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rutubishi.calculatorkmp.common.ui.presentation.components.FunctionKey
import com.rutubishi.calculatorkmp.common.ui.presentation.components.KeyLayout

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 8.dp)){

        Text("Hello", modifier = Modifier.weight(0.3f))

        Card(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxHeight()
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.inverseSurface,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)) {

                KeyLayout {
                    FunctionKey(onClick = {}, value = 'C')
                    FunctionKey(onClick = {}, value = '%')
                    FunctionKey(onClick = {}, value = '/')
                    FunctionKey(onClick = {})
                }

                KeyLayout {

                }

            }


        }

    }
}