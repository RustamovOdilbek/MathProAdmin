package com.mathpro.admin.model.lesson

import com.google.gson.annotations.SerializedName

data class CreateLessonRequest(

    @SerializedName("bob_id"      ) var bobId       : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("pdf_link"    ) var pdfLink     : String? = null,
    @SerializedName("theme"       ) var theme       : String? = null,
    @SerializedName("video_link"  ) var videoLink   : String? = null
)
