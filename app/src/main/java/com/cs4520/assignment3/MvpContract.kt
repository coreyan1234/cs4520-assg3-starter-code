package com.cs4520.assignment3

interface MvpContract {
    interface View {
        fun showResult(result: Double)
        fun clearInputs()
        fun showToast(message: String)
    }

    interface Model {
        fun add(num1: Double, num2: Double): Double
        fun subtract(num1: Double, num2: Double): Double
        fun multiply(num1: Double, num2: Double): Double
        fun divide(num1: Double, num2: Double): Double
        fun isValidInput(num1: Double, num2: Double): Boolean
    }

    interface Presenter {
        fun onAddClicked()
        fun onSubtractClicked()
        fun onMultiplyClicked()
        fun onDivideClicked()
    }
}