package com.mathpro.admin.ui.fragment.lessons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentLessonsBinding

class LessonsFragment : Fragment(R.layout.fragment_lessons) {
    private lateinit var binding: FragmentLessonsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLessonsBinding.bind(view)

        initVoews()
    }

    private fun initVoews() {

    }


}