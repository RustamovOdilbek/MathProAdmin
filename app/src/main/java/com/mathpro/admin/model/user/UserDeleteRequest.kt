package com.mathpro.admin.model.user

import com.google.gson.annotations.SerializedName

data class UserDeleteRequest (

    @SerializedName("id" ) var id : String? = null

)