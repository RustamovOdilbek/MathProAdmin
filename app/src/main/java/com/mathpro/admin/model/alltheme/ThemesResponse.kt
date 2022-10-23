package com.mathpro.admin.model.alltheme

import com.google.gson.annotations.SerializedName

data class ThemesResponse(

    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)

data class Data (

    @SerializedName("lessons" ) var lessons : ArrayList<Lessons> = arrayListOf(),
    @SerializedName("number"  ) var number  : Int?               = null

)

data class Lessons (

    @SerializedName("id"            ) var id           : String? = null,
    @SerializedName("bob_id"        ) var bobId        : String? = null,
    @SerializedName("theme"         ) var theme        : String? = null,
    @SerializedName("description"   ) var description  : String? = null,
    @SerializedName("video_link"    ) var videoLink    : String? = null,
    @SerializedName("pdf_link"      ) var pdfLink      : String? = null,
    @SerializedName("lesson_number" ) var lessonNumber : Int?    = null

)
