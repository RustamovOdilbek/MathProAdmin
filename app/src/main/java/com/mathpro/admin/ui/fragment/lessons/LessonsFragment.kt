package com.mathpro.admin.ui.fragment.lessons

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mathpro.admin.R
import com.mathpro.admin.adapter.AddTestAdapter
import com.mathpro.admin.databinding.FragmentLessonsBinding
import com.mathpro.admin.helper.OnClickEvent
import com.mathpro.admin.model.Test
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.ui.fragment.users.UserViewModel
import com.mathpro.admin.ui.fragment.users.UsersViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LessonsFragment : Fragment(R.layout.fragment_lessons) {
    private val TAG = "LessonsFragment"
    private lateinit var binding: FragmentLessonsBinding
    private val viewModel: LessonsViewModel by viewModels<LessonsViewModelImp>()
    private lateinit var adapter: AddTestAdapter
    private val IMAGE_PICKER_SELECT = 1001
    private lateinit var testList: ArrayList<Test>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLessonsBinding.bind(view)
        testList = ArrayList()

        initVoews()
    }

    private fun initVoews() {
        adapter = AddTestAdapter(object : OnClickEvent{
            override fun setOnImageOrVedioClickListener(position: Int) {
                pickGalleryPhotoOrVedio()
            }

        })

        roleSpinner()

        binding.recyclerView.adapter = adapter

        var a = 1
        binding.btnAddTest.setOnClickListener {
            testList.add(Test(a++))
            adapter.submitData(testList)
        }

        binding.btnSave.setOnClickListener {

            val description = binding.etDescription.text.toString()
            val pdfLink = binding.etPdfLink.text.toString()
            val theme = binding.etThemeLink.text.toString()
            val videoLink = binding.etVideoLink.text.toString()
            val createLessonRequest = CreateLessonRequest("b4194e55-b86a-4e59-99a9-089813f428db",
                description = description, pdfLink = pdfLink,
                theme = theme, videoLink = videoLink)

            viewModel.createLesson(createLessonRequest){
                it.onSuccess { createLessonResponse ->
                    Log.d(TAG, "initViews: ${createLessonResponse}")
                }
                it.onFailure {
                    Log.d(TAG, "error: ${it.message}")
                }
            }
        }

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    @SuppressLint("IntentReset")
    fun pickGalleryPhotoOrVedio(){
        val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickIntent.type = "image/* video/*"
        startActivityForResult(pickIntent, IMAGE_PICKER_SELECT)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICKER_SELECT && resultCode == RESULT_OK && data != null && data.data != null) {
            val selectedMediaUri: Uri = data.getData()!!
            if (selectedMediaUri.toString().contains("image")) {
                //handle image
                Log.d(TAG, "onActivityResult: ${selectedMediaUri}")
            } else if (selectedMediaUri.toString().contains("video")) {
                //handle video
                Log.d(TAG, "onActivityResult: ${selectedMediaUri}")
            }
        }
    }

    private fun roleSpinner() {
       viewModel.allChapters {
            it.onSuccess { allCHapter ->
                val array: ArrayList<String> = arrayListOf()
                allCHapter.data!!.bobs.forEach {
                    array.add(it.name!!)
                }
                val adapter: ArrayAdapter<String> =
                    ArrayAdapter(requireContext(), R.layout.dropdown_menu_popup_item, array)
                Log.d(TAG, "initViews: ${allCHapter}")
                val editTextFilledExposedDropdown = binding.filledExposedDropdownBob

                editTextFilledExposedDropdown.setAdapter(adapter)
            }
            it.onFailure {
                Log.d(TAG, "error: ${it.message}")
            }
        }

    }
}