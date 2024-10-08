package com.ukmprogramming.recyco.data.network.response

import com.google.gson.annotations.SerializedName
import com.ukmprogramming.recyco.data.network.response.models.LoginData

data class LoginResponse(
    @field:SerializedName("data")
    val data: LoginData? = null,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
