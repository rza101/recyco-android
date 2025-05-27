package com.ukmprogramming.recyco.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.ukmprogramming.recyco.data.network.response.models.TreatmentLocation

@Keep
data class TreatmentLocationsResponse(
    @field:SerializedName("data")
    val data: List<TreatmentLocation>? = null,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
