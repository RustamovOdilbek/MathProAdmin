package com.mathpro.admin.ui.fragment.chapter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mathpro.admin.R
import com.mathpro.admin.adapter.ChapterAdapter
import com.mathpro.admin.databinding.FragmentChapterBinding
import com.mathpro.admin.utils.ChapterDialog
import com.mathpro.admin.utils.KeyValues.CHAPTER_ID
import com.mathpro.admin.utils.viewExtension.back
import dagger.hilt.android.AndroidEntryPoint

/**
 * ChapterFragment Rustamov Odilbek 17/10/2022
 */
@AndroidEntryPoint
class ChapterFragment : Fragment(R.layout.fragment_chapter) {
    private val TAG = "ChapterFragment"
    private val binding by viewBinding(FragmentChapterBinding::bind)
    private val viewModel: ChapterViewModel by viewModels<ChapterViewModelImp>()
    private lateinit var adapter: ChapterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {

        adapter = ChapterAdapter(){id->
            Log.d(TAG, "initViews: ${id}")
            findNavController().navigate(R.id.action_chapterFragment_to_allThemeFragment,
                bundleOf( CHAPTER_ID to id)
            )
        }
        binding.recyclerView.adapter = adapter

        allChapters()

        binding.ivAddChapter.setOnClickListener {
            addChapter()
        }

        binding.ivBack.setOnClickListener { back() }

    }

    private fun addChapter() {
        val dialog = ChapterDialog(){ chapter ->
            viewModel.addChapter(chapter, {
                Log.d(TAG, "addChapter: ${it}")
                allChapters()
            })
        }

        dialog.showCalendarDialog(requireActivity())
    }

    private fun allChapters() {
        viewModel.allChapters {
            it.onSuccess { usersResponse ->
                Log.d(TAG, "initViews: ${usersResponse}")
                adapter.currentList.clear()
                adapter.submitData(usersResponse.data!!.bobs)

            }
            it.onFailure {
                Log.d(TAG, "error: ${it.message}")
            }
        }
    }
}