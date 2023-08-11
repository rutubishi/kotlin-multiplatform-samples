package com.rutubishi.calculatorkmp.common.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rutubishi.calculatorkmp.common.ui.presentation.components.FunctionKey
import com.rutubishi.calculatorkmp.common.ui.presentation.components.KeyLayout
import com.rutubishi.calculatorkmp.common.ui.presentation.components.NumberKey
import com.rutubishi.calculatorkmp.common.ui.presentation.components.SubmitCalculation

@Composable
@ExperimentalMaterial3Api
fun AppScreen(
    modifier: Modifier = Modifier,
){
    var displayOut by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(top = 8.dp)
            .verticalScroll(rememberScrollState())){

        Box(
            modifier = Modifier.weight(0.4f),
            contentAlignment = Alignment.BottomEnd
        ) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                textStyle = MaterialTheme.typography.displayLarge.copy(
                    textAlign = TextAlign.End
                ),
                value = displayOut,
                onValueChange = { displayOut = it },
                colors = TextFieldDefaults.textFieldColors(
                    MaterialTheme.colorScheme.onSurfaceVariant,
                    containerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

        }


        Card(
            shape = RoundedCornerShape(
                bottomEnd = 0.dp,
                bottomStart = 0.dp,
                topStart = 25.dp,
                topEnd = 25.dp),
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
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
                    NumberKey(onClick = {}, value = '9')
                    NumberKey(onClick = {}, value = '8')
                    NumberKey(onClick = {}, value = '7')
                    FunctionKey(onClick = {}, content = {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null
                        )
                    })
                }

                KeyLayout {
                    NumberKey(onClick = {}, value = '6')
                    NumberKey(onClick = {}, value = '5')
                    NumberKey(onClick = {}, value = '4')
                    FunctionKey(onClick = {}, content = {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = null
                        )
                    })
                }

                KeyLayout {
                    NumberKey(onClick = {}, value = '3')
                    NumberKey(onClick = {}, value = '2')
                    NumberKey(onClick = {}, value = '1')
                    FunctionKey(onClick = {}, content = {
                        Icon(
                            imageVector = Icons.Filled.Backspace,
                            contentDescription = null
                        )
                    })
                }

                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    NumberKey(onClick = {}, value = '0', modifier = Modifier.weight(1f))
                    NumberKey(onClick = {}, value = '.', modifier = Modifier.weight(1f))
                    SubmitCalculation(modifier = Modifier.weight(2f))
                }

            }


        }

    }
}