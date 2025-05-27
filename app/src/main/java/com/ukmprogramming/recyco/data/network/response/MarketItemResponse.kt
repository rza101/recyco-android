package com.ukmprogramming.recyco.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.ukmprogramming.recyco.data.network.response.models.MarketItem

@Keep
data class MarketItemResponse(
    @field:SerializedName("data")
    val data: MarketItem? = null,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
