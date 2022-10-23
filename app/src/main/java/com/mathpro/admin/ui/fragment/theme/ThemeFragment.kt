package com.mathpro.admin.ui.fragment.theme

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentAllThemeBinding
import com.mathpro.admin.databinding.FragmentChapterBinding
import com.mathpro.admin.ui.fragment.chapter.ChapterViewModel
import com.mathpro.admin.ui.fragment.chapter.ChapterViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThemeFragment : Fragment(R.layout.fragment_theme) {
    private val TAG = "ChapterFragment"
    private val binding by viewBinding(FragmentAllThemeBinding::bind)
    private val viewModel: ThemeViewModel by viewModels<ThemeViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {



    }

}