package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MvvmViewModel: ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun add(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun subtract(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun multiply(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun divide(num1: Double, num2: Double): Double {
        return if (num2 != 0.0) {
            num1 / num2
        } else {
            Double.NaN
        }
    }

    fun isValidInput(num1: Double, num2: Double): Boolean {
        return !num1.isNaN() && !num2.isNaN()
    }

    fun setResultText(resultText: String) {
        _result.value = resultText
    }
}