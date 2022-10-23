package com.mathpro.admin.ui.fragment.alltheme

import com.mathpro.admin.model.alltheme.ThemesResponse

interface AllThemeViewModel {

    fun createLesson(id: String, block: (Result<ThemesResponse>) -> Unit)

}