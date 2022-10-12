package com.mathpro.admin.ui.fragment.dailynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentDailyNewsBinding

class DailyNewsFragment : Fragment(R.layout.fragment_daily_news) {
    private lateinit var binding: FragmentDailyNewsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDailyNewsBinding.bind(view)

        initViews()
    }

    private fun initViews() {

    }

}