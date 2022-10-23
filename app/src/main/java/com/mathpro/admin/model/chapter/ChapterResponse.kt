package com.mathpro.admin.model.chapter

import com.google.gson.annotations.SerializedName

data class ChapterResponse (

    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)

data class Data (

    @SerializedName("bobs"   ) var bobs   : ArrayList<Bobs> = arrayListOf(),
    @SerializedName("number" ) var number : Int?            = null

)

data class Bobs (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)