package com.mathpro.admin.model.chapter

import com.google.gson.annotations.SerializedName

data class EditChapterRequest(
    @SerializedName("name" ) var name : String? = null
)