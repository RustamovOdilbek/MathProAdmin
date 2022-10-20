package com.mathpro.admin.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)


data class Data (

    @SerializedName("token" ) var token : String? = null

)