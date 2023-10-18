package com.example.colorbliss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.colorbliss.databinding.ActivityMainBinding
import com.example.colorbliss.presentation.HomeFragment
import com.example.colorbliss.utilits.APP_ACTIVITY
import com.example.colorbliss.utilits.replaceFragmentMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        replaceFragmentMain(HomeFragment())
    }
}