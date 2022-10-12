package com.mathpro.admin.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        binding.btnUsers.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_usersFragment)
        }
        binding.btnLessons.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_lessonsFragment)
        }

        binding.btnDailyNews.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_dailyNewsFragment)
        }
        binding.btnMotivationalVideos.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_motivationalVideosFragment)
        }

        binding.btnVariantTests.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_variantTestsFragment)
        }
    }

}