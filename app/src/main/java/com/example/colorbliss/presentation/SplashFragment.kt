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
import com.example.colorbliss.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SettingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            val code = viewModel.codeSher.getInt("code", 0)
            if (code == 1){
                replaceFragmentMain(HomeFragment())
            } else{
                replaceFragmentMain(OnBoardingFragment())
            }
        }, 3000)

        return binding.root
    }
}