package com.mathpro.admin.utils.viewExtension

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun Fragment.snackBar(msg: String) {
    Snackbar.make(this.requireView(), msg, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.back() {
    requireActivity().onBackPressed()
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateConvert(BirthDate: String): String{
    val inputFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    val outputFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("dd/MM/yyy", Locale.ENGLISH)
    val date: LocalDate = LocalDate.parse(BirthDate, inputFormatter)
    val formattedDate: String = outputFormatter.format(date)
    println(formattedDate)
    return formattedDate
}