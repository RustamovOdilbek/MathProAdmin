package com.mathpro.admin.ui.fragment.motivation

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentMotivationalVideosBinding

class MotivationalVideosFragment : Fragment(R.layout.fragment_motivational_videos) {
    private val TAG = "MotivationalVideosFragm"
    private lateinit var binding: FragmentMotivationalVideosBinding
    private var RESULT_CODE = 1001

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMotivationalVideosBinding.bind(view)

        initViews()
    }

    private fun initViews() {

        binding.llUploadImage.setOnClickListener {
            selectImage()
        }

    }

    private fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) intent.action =
            Intent.ACTION_GET_CONTENT
        val chooserIntent = Intent.createChooser(intent, "Complete action using")

        startActivityForResult(chooserIntent, RESULT_CODE)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_CODE && resultCode == Activity.RESULT_OK) {
            try {
                val selectedImageUri: Uri = data?.data!!
                Log.d(TAG, "onActivityResult: ${selectedImageUri}")
                binding.tvUploadImage.text = requireActivity().resources.getText(R.string.str_image_uploaded)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}