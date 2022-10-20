package com.mathpro.admin.model.chapter

import com.google.gson.annotations.SerializedName

data class AddChapterResponse(
    @SerializedName("data"    ) var data    : Chapter?    = Chapter(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null
)

data class Chapter (

    @SerializedName("ID"   ) var ID   : String? = null,
    @SerializedName("Name" ) var Name : String? = null

)
