package com.cs4520.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cs4520.assignment3.databinding.ActivityMainBinding
import com.cs4520.assignment3.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}