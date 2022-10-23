package com.mathpro.admin.model.theme

import com.google.gson.annotations.SerializedName

data class DeleteLessonRequest(

    @SerializedName("bob_id"        ) var bobId        : String? = null,
    @SerializedName("lesson_number" ) var lessonNumber : Int?    = null

)
