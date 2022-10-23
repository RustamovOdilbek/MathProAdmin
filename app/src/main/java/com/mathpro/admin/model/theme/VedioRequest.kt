package com.mathpro.admin.model.theme

import com.google.gson.annotations.SerializedName

data class VedioRequest(

    @SerializedName("lesson_id"      ) var lessonId     : String? = null,
    @SerializedName("new_video_link" ) var newVideoLink : String? = null

)
