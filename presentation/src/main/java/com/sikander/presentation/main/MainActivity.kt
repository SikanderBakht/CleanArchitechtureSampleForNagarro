package com.sikander.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.sikander.presentation.R
import com.sikander.presentation.databinding.ActivityMainBinding
import com.sikander.presentation.extension.viewInflateBinding
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewInflateBinding(ActivityMainBinding::inflate)
    private val navController: NavController by lazy {
        findNavController(R.id.activityMainFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}