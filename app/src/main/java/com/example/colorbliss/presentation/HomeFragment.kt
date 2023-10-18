package com.example.colorbliss.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.colorbliss.databinding.FragmentHomeBinding
import com.example.colorbliss.presentation.adapter.PicAdapter
import com.example.colorbliss.presentation.adapter.listener.PicListener
import com.example.colorbliss.utilits.replaceFragmentMain
import com.example.colorbliss.viewmodel.PicViewModel
import com.example.domain.entities.Picture
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(),
    PicListener{
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val paintingsViewModel by viewModel<PicViewModel>()
    private val adapter = PicAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        observeData()

        return binding.root
    }

    private fun observeData() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.adapter = adapter
        adapter.setItem(paintingsViewModel.getResultPic())
    }

    override fun getPicListener(picture: Picture) {
        replaceFragmentMain(ColoringFragment(picture))
    }
}