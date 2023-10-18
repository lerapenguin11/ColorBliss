package com.example.colorbliss.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.colorbliss.R
import com.example.colorbliss.databinding.FragmentOnBoardingBinding
import com.example.colorbliss.utilits.replaceFragmentMain
import com.example.colorbliss.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment : Fragment() {
    private var _binding : FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SettingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.getCode(1)
            replaceFragmentMain(HomeFragment())
        }, 4000)

        return binding.root
    }
}