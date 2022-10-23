package com.mathpro.admin.model.theme

import com.google.gson.annotations.SerializedName

data class ThemeRequest(

    @SerializedName("lesson_id" ) var lessonId : String? = null,
    @SerializedName("new_theme" ) var newTheme : String? = null


)
