package com.ukmprogramming.recyco.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BaseResponse(
    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
