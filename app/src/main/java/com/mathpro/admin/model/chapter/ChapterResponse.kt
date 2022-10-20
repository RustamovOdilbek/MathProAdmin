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

    @SerializedName("ID"   ) var ID   : String? = null,
    @SerializedName("Name" ) var Name : String? = null

)