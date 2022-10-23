package com.mathpro.admin.model.theme

import com.google.gson.annotations.SerializedName

data class DescriptionRequest(

    @SerializedName("lesson_id"       ) var lessonId       : String? = null,
    @SerializedName("new_description" ) var newDescription : String? = null

)
