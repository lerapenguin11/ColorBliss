package com.example.colorbliss.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.colorbliss.R
import com.example.colorbliss.databinding.FragmentHomeBinding
import com.example.colorbliss.databinding.FragmentSplashBinding
import com.example.colorbliss.utilits.replaceFragmentMain

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        /*Handler(Looper.getMainLooper()).postDelayed({
            //getCheck(code)
            replaceFragmentMain(fragment)
        }, 3000)*/

        return binding.root
    }
}