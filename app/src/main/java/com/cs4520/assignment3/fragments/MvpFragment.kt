package com.cs4520.assignment3.fragments

import android.icu.util.IslamicCalendar.CalculationType
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cs4520.assignment3.MvpContract
import com.cs4520.assignment3.MvpPresenter
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MvpFragment : Fragment(), MvpContract.View {
    private var _binding: FragmentMvpBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MvpContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMvpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MvpPresenter(this)
        binding.apply {
            buttonAdd.setOnClickListener { presenter.onAddClicked() }
            buttonSubtract.setOnClickListener { presenter.onSubtractClicked() }
            buttonMultiply.setOnClickListener { presenter.onMultiplyClicked() }
            buttonDivide.setOnClickListener { presenter.onDivideClicked() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showResult(result: String) {
        binding.textViewResult.text = result
    }

    override fun clearInputs() {
        binding.editTextNum1.text.clear()
        binding.editTextNum2.text.clear()
    }

    override fun showToastError() {
        Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
    }

    override fun getNum1(): Double {
        return binding.editTextNum1.text.toString().toDoubleOrNull() ?: Double.NaN
    }

    override fun getNum2(): Double {
        return binding.editTextNum2.text.toString().toDoubleOrNull() ?: Double.NaN
    }


}