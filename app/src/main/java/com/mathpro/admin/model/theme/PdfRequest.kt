package com.mathpro.admin.model.theme

import com.google.gson.annotations.SerializedName

data class PdfRequest(

    @SerializedName("lesson_id"    ) var lessonId   : String? = null,
    @SerializedName("new_pdf_link" ) var newPdfLink : String? = null

)