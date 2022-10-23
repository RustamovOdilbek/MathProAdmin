package com.mathpro.admin.model.chapter

import com.google.gson.annotations.SerializedName

data class AddChapterResponse(

    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)

data class Chapter (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)
