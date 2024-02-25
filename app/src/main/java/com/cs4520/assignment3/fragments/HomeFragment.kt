package com.cs4520.assignment3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Button listeners
        binding.buttonMvp.setOnClickListener{ navigateToMVPFragment() }
        binding.buttonMvvm.setOnClickListener{ navigateToMVVMFragment() }
    }

    private fun navigateToMVPFragment() {
        // Navigate to MVPFragment
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, MVPFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun navigateToMVVMFragment() {
        // Navigate to MVVMFragment
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, MVVMFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}