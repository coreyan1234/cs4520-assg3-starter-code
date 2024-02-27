package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMvvmBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MvvmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MvvmFragment : Fragment() {
    private var _binding: FragmentMvvmBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MvvmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMvvmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MvvmViewModel::class.java]

        // Survive orientation change
        viewModel.result.observe(viewLifecycleOwner) { result ->
            binding.textViewResult.text = result
        }

        binding.apply {
            buttonAdd.setOnClickListener { calculate("ADD") }
            buttonSubtract.setOnClickListener { calculate("SUBTRACT") }
            buttonMultiply.setOnClickListener { calculate("MULTIPLY") }
            buttonDivide.setOnClickListener { calculate("DIVIDE") }
        }
    }

    private fun calculate(operation: String) {
        val num1 = binding.editTextNum1.text.toString().toDoubleOrNull() ?: Double.NaN
        val num2 = binding.editTextNum2.text.toString().toDoubleOrNull() ?: Double.NaN

        if (!viewModel.isValidInput(num1, num2)) {
            showToastError()
            return
        }

        val result = when (operation) {
            "ADD" -> viewModel.add(num1, num2)
            "SUBTRACT" -> viewModel.subtract(num1, num2)
            "MULTIPLY" -> viewModel.multiply(num1, num2)
            "DIVIDE" -> viewModel.divide(num1, num2)
            else -> {
                showToastError()
                return
            }
        }

        if (result.isNaN()) {
            showToastError()
            return
        }

        viewModel.setResultText("Result: $result")
        clearInputs()
    }

    private fun clearInputs() {
        binding.editTextNum1.text.clear()
        binding.editTextNum2.text.clear()
    }

    private fun showToastError() {
        Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}