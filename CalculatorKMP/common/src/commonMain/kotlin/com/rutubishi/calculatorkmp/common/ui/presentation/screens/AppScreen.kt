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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rutubishi.calculatorkmp.common.data.CalculatorLogic
import com.rutubishi.calculatorkmp.common.ui.presentation.components.FunctionKey
import com.rutubishi.calculatorkmp.common.ui.presentation.components.KeyLayout
import com.rutubishi.calculatorkmp.common.ui.presentation.components.NumberKey
import com.rutubishi.calculatorkmp.common.ui.presentation.components.SubmitCalculation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
@ExperimentalMaterial3Api
fun AppScreen(
    modifier: Modifier = Modifier,
    opScope: CoroutineScope = CoroutineScope(Dispatchers.Default)
){
    val currentInput = CalculatorLogic.calculatorInput.collectAsState()
    val currentSolution = CalculatorLogic.solution.collectAsState()
    val stack = CalculatorLogic.inputStack

    fun setInput(value: String) = opScope.launch {
        stack.add(value.first())
        CalculatorLogic.setInput("${ currentInput.value ?: "" }$value")
    }

    fun clearInput() = opScope.launch {
        CalculatorLogic.clearInput()
    }

    fun deleteLast() = opScope.launch {
        CalculatorLogic.setInput(
            currentInput.value?.take(currentInput.value!!.length - 1) ?: ""
        )
    }

    fun solve() = opScope.launch {
        CalculatorLogic.solve()
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(top = 8.dp)
            .verticalScroll(rememberScrollState())){

        Box(
            modifier = Modifier.weight(0.4f),
            contentAlignment = Alignment.BottomEnd
        ) {

            Text(
                text = currentSolution.value ?: "",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .height(75.dp)
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                style = MaterialTheme.typography.displayMedium.copy(
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                textStyle = MaterialTheme.typography.displayLarge.copy(
                    textAlign = TextAlign.End
                ),
                value = currentInput.value ?: "",
                onValueChange = { },
                colors = TextFieldDefaults.textFieldColors(
                    MaterialTheme.colorScheme.onSurfaceVariant,
                    containerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
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
                    FunctionKey(onClick = { clearInput() }, value = 'C')
                    FunctionKey(onClick = {}, value = '%')
                    FunctionKey(onClick = { setInput("/") }, value = '/')
                    FunctionKey(onClick = { setInput("+") })
                }

                KeyLayout {
                    NumberKey(onClick = { setInput("9") }, value = '9')
                    NumberKey(onClick = { setInput("8") }, value = '8')
                    NumberKey(onClick = { setInput("7") }, value = '7')
                    FunctionKey(onClick = { setInput("x") }, content = {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null
                        )
                    })
                }

                KeyLayout {
                    NumberKey(onClick = { setInput("6") }, value = '6')
                    NumberKey(onClick = { setInput("5") }, value = '5')
                    NumberKey(onClick = { setInput("4") }, value = '4')
                    FunctionKey(onClick = { setInput("-") }, content = {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = null
                        )
                    })
                }

                KeyLayout {
                    NumberKey(onClick = { setInput("3") }, value = '3')
                    NumberKey(onClick = { setInput("2") }, value = '2')
                    NumberKey(onClick = { setInput("1") }, value = '1')
                    FunctionKey(onClick = ::deleteLast, content = {
                        Icon(
                            imageVector = Icons.Filled.Backspace,
                            contentDescription = null
                        )
                    })
                }

                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    NumberKey(onClick = { setInput("0") }, value = '0', modifier = Modifier.weight(1f))
                    NumberKey(onClick = { setInput(".") }, value = '.', modifier = Modifier.weight(1f))
                    SubmitCalculation(modifier = Modifier.weight(2f)){ solve() }
                }

            }


        }

    }
}