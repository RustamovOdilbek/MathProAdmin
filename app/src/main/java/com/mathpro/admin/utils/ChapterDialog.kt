package com.mathpro.admin.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.mathpro.admin.databinding.DialogAddChapterBinding

class ChapterDialog(private var onItemClicked: ((String) -> Unit)) {

    fun showCalendarDialog(activity: Activity?) {
        val binding = DialogAddChapterBinding.inflate(LayoutInflater.from(activity))
        val dialog = Dialog(activity!!)
        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)
            setContentView(binding.root)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(true)
        }

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnAdd.setOnClickListener {
            val chapter = binding.etAddChapter.text.toString()
            onItemClicked.invoke(chapter)
            dialog.dismiss()
        }

        dialog.show()
    }

}