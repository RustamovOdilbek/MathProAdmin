package com.mathpro.admin.model.user

import com.google.gson.annotations.SerializedName


data class UserDeleteResponse (

    @SerializedName("Message" ) var Message : String?  = null,
    @SerializedName("Success" ) var Success : Boolean? = null

)