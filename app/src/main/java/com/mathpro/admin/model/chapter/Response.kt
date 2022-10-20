package com.mathpro.admin.model.chapter

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null
)