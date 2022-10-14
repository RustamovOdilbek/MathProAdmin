package com.mathpro.admin.model.user

import com.google.gson.annotations.SerializedName


data class UsersResponse (
    @SerializedName("ID"        ) var ID        : String?  = null,
    @SerializedName("FullName"  ) var FullName  : String?  = null,
    @SerializedName("Login"     ) var Login     : String?  = null,
    @SerializedName("Password"  ) var Password  : String?  = null,
    @SerializedName("Viloyat"   ) var Viloyat   : String?  = null,
    @SerializedName("BirthDate" ) var BirthDate : String?  = null,
    @SerializedName("Email"     ) var Email     : String?  = null,
    @SerializedName("Phone"     ) var Phone     : String?  = null,
    @SerializedName("Study"     ) var Study     : String?  = null,
    @SerializedName("Payed"     ) var Payed     : Boolean? = null
)