package com.mathpro.admin.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("Message" ) var Message : String?  = null,
    @SerializedName("Success" ) var Success : Boolean? = null,
    @SerializedName("Token"   ) var Token   : String?  = null

)