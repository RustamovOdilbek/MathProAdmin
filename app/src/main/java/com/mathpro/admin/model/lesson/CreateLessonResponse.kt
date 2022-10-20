package com.mathpro.admin.model.lesson

import com.google.gson.annotations.SerializedName

data class CreateLessonResponse(

    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)

data class Data (

    @SerializedName("ID"          ) var ID          : String? = null,
    @SerializedName("BobID"       ) var BobID       : String? = null,
    @SerializedName("Theme"       ) var Theme       : String? = null,
    @SerializedName("Description" ) var Description : String? = null,
    @SerializedName("VideoLink"   ) var VideoLink   : String? = null,
    @SerializedName("PdfLink"     ) var PdfLink     : String? = null

)