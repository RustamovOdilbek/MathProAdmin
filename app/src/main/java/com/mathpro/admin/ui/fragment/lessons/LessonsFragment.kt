package com.mathpro.admin.ui.fragment.lessons

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mathpro.admin.R
import com.mathpro.admin.adapter.AddTestAdapter
import com.mathpro.admin.databinding.FragmentLessonsBinding
import com.mathpro.admin.helper.OnClickEvent
import com.mathpro.admin.model.Test

class LessonsFragment : Fragment(R.layout.fragment_lessons) {
    private val TAG = "LessonsFragment"
    private lateinit var binding: FragmentLessonsBinding
    private lateinit var adapter: AddTestAdapter
    private val PICK_PDF_REQUEST = 1001
    private val IMAGE_PICKER_SELECT = 1002
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

        binding.llUploadFile.setOnClickListener {
            uploadFile()
        }
        var a = 1
        binding.btnAddTest.setOnClickListener {
            testList.add(Test(a++))
            adapter.submitData(testList)
        }

    }

    private fun uploadFile() {
        val intent = Intent()
        intent.setType("application/msword|text/plain|application/pdf");
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST)
    }

    fun pickGalleryPhotoOrVedio(){
        val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickIntent.type = "image/* video/*"
        startActivityForResult(pickIntent, IMAGE_PICKER_SELECT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            var filePath = data.data
            Log.d(TAG, "onActivityResult: ${filePath!!.pathSegments.last()}")
            binding.tvSaveDoc.text = filePath.pathSegments.last()

        }else if (requestCode == IMAGE_PICKER_SELECT && resultCode == RESULT_OK && data != null && data.data != null) {
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
        val type: Array<String> = arrayOf("1-bob Numberlar", "2-bob Kasr sonlar", "3-bob Tenglamalar", "4-bob Tengsizliklar")
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(requireContext(), R.layout.dropdown_menu_popup_item, type)
        val editTextFilledExposedDropdown = binding.filledExposedDropdownBob

        editTextFilledExposedDropdown.setAdapter(adapter)

        val editTextFilledExposedDropdownSubject = binding.filledExposedDropdownSubject

        editTextFilledExposedDropdownSubject.setAdapter(adapter)
    }
}