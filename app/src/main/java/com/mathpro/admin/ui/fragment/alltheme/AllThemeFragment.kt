package com.mathpro.admin.ui.fragment.alltheme

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentAllThemeBinding
import com.mathpro.admin.databinding.FragmentChapterBinding
import com.mathpro.admin.ui.fragment.chapter.ChapterViewModel
import com.mathpro.admin.ui.fragment.chapter.ChapterViewModelImp
import com.mathpro.admin.utils.KeyValues.CHAPTER_ID
import dagger.hilt.android.AndroidEntryPoint

/**
 * AllThemeFragment Rustamov Odilbek 23/10/2022
 */
@AndroidEntryPoint
class AllThemeFragment : Fragment(R.layout.fragment_all_theme) {
    private val TAG = "AllThemeFragment"
    private val binding by viewBinding(FragmentAllThemeBinding::bind)
    private val viewModel: AllThemeViewModel by viewModels<AllThemeViewModelImp>()
    private lateinit var chapter_id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chapter_id = arguments?.get(CHAPTER_ID).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: ")
        Log.d(TAG, "onViewCreated: ${chapter_id}")
        initViews()
    }

    private fun initViews() {
        viewModel.createLesson(chapter_id){
            it.onSuccess { allthemes ->
                Log.d(TAG, "initViews: ${allthemes}")

            }
            it.onFailure {
                Log.d(TAG, "error: ${it.message}")
            }
        }
    }

}