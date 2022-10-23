package com.mathpro.admin.model.user

import com.google.gson.annotations.SerializedName


data class UsersResponse (
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("success" ) var success : Boolean? = null

)


data class Data (

    @SerializedName("users"  ) var users  : ArrayList<Users> = arrayListOf(),
    @SerializedName("number" ) var number : Int?             = null

)

data class Users (

    @SerializedName("id"           ) var id          : String?  = null,
    @SerializedName("full_name"    ) var fullName    : String?  = null,
    @SerializedName("login"        ) var login       : String?  = null,
    @SerializedName("password"     ) var password    : String?  = null,
    @SerializedName("viloyat"      ) var viloyat     : String?  = null,
    @SerializedName("birth_day"    ) var birthDay    : String?  = null,
    @SerializedName("email"        ) var email       : String?  = null,
    @SerializedName("phone_number" ) var phoneNumber : String?  = null,
    @SerializedName("study"        ) var study       : String?  = null,
    @SerializedName("payed"        ) var payed       : Boolean? = null

)