package com.rutubishi.calculatorkmp.common.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Stack

object CalculatorLogic {

    private val _calculatorInput: MutableStateFlow<String?> = MutableStateFlow(null)
    val calculatorInput: StateFlow<String?> = _calculatorInput

    private val _solution: MutableStateFlow<String?> = MutableStateFlow(null)
    val solution: StateFlow<String?> = _solution

    private val currInput: MutableStateFlow<String?> = MutableStateFlow(null)
    private val fKeys = arrayOf('x','+','-','/')
    private var tmpValue: Double = 0.0
    private var tmpValueB: Double = 0.0
    private var tmpSolution: Double = 0.0
    private var fKeyPressed: Boolean = false
    private var currFKey = '+'
    val inputStack = Stack<Char>()

    /**
     *  Confirm the input key
     * */
    suspend fun setInput(value: String) {
        val key = value.last()
        val isFxn = key in fKeys
        _calculatorInput.emit(
            if(calculatorInput.value.isNullOrBlank() && isFxn)
                "$tmpValue$value"
            else {
                println("key: $key")
                tmpValue = if(calculatorInput.value.isNullOrBlank()) 0.0 else tmpValue
                value
            }
        )
        if (isFxn){
            fKeyPressed = true
            currFKey = key
            currInput.emit(null)
        }else{
            currInput.emit("${currInput.value?:""}$key")
            if(!fKeyPressed) tmpValue = currInput.value?.toDouble() ?: 0.0
            else if(key in fKeys){
                operate()
                tmpValueB = 0.0
            }else{
               tmpValueB = currInput.value?.toDouble() ?: 0.0
            }
            println("Temp Value: $tmpValue, operand: $tmpValueB")
        }
    }

    /**
     *  Clear display text
     * */
    suspend fun clearInput(){
        _calculatorInput.emit(null)
        _solution.emit(null)
        currInput.emit(null)
        tmpValue = 0.0
        tmpValueB = 0.0
        tmpSolution = 0.0
    }

    /**
     *  Display answer
     * */
    suspend fun solve(){
        if(inputStack.peek() in fKeys){
            _solution.emit("%SYNTAX ERROR%")
        } else {
            _solution.emit(operate().toString())
            _calculatorInput.emit(null)
        }
    }

    /**
     * Confirm current operation between 2 operands
     * */
    private fun operate(): Double {
        tmpSolution = when(currFKey){
            'x' -> tmpValue * tmpValueB
            '+' -> tmpValue + tmpValueB
            '-' -> tmpValue - tmpValueB
            '/' -> tmpValue / tmpValueB
            else -> 0.0
        }
        tmpValue = tmpSolution
        tmpValueB = 0.0
        return tmpSolution
    }

}