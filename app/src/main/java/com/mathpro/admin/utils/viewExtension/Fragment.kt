package com.mathpro.admin.utils.viewExtension

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackBar(msg: String) {
    Snackbar.make(this.requireView(), msg, Snackbar.LENGTH_SHORT).show()
}