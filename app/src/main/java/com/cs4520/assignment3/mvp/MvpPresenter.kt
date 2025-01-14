package com.cs4520.assignment3.mvp

import com.cs4520.assignment3.mvp.MvpContract
import com.cs4520.assignment3.mvp.MvpModel

class MvpPresenter(private val view: MvpContract.View): MvpContract.Presenter {
    private val model: MvpContract.Model = MvpModel()

    override fun onAddClicked() {
        val num1 = view.getNum1()
        val num2 = view.getNum2()
        if (model.isValidInput(num1, num2)) {
            val result = model.add(num1, num2)
            val resultString = "Result: $result"
            view.showResult(resultString)
            view.clearInputs()
        }
        else {
            view.showToastError()
        }
    }

    override fun onSubtractClicked() {
        val num1 = view.getNum1()
        val num2 = view.getNum2()
        if (model.isValidInput(num1, num2)) {
            val result = model.subtract(num1, num2)
            val resultString = "Result: $result"
            view.showResult(resultString)
            view.clearInputs()
        }
        else {
            view.showToastError()
        }
    }

    override fun onMultiplyClicked() {
        val num1 = view.getNum1()
        val num2 = view.getNum2()
        if (model.isValidInput(num1, num2)) {
            val result = model.multiply(num1, num2)
            val resultString = "Result: $result"
            view.showResult(resultString)
            view.clearInputs()
        }
        else {
            view.showToastError()
        }
    }

    override fun onDivideClicked() {
        val num1 = view.getNum1()
        val num2 = view.getNum2()
        if (model.isValidInput(num1, num2) && num2 != 0.0) {
            val result = model.divide(num1, num2)
            val resultString = "Result: $result"
            view.showResult(resultString)
            view.clearInputs()
        }
        else {
            view.showToastError()
        }
    }

}