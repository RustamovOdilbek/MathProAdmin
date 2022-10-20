package com.mathpro.admin.model.user

import com.google.gson.annotations.SerializedName


data class UserDeleteResponse (


    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)