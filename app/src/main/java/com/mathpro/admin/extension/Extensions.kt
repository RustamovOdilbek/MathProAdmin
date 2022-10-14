package com.example.mathpro.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun timeFormat(time: String): String {
    val sourceFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    val destFormat = SimpleDateFormat("yyyy.MM.dd")
    val convertedDate = sourceFormat.parse(time)


    return destFormat.format(convertedDate)
}
