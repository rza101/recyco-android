package com.ukmprogramming.recyco.data.network.response.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class MarketItem(
    @SerializedName("price")
    val price: Double,

    @SerializedName("name")
    val name: String,

    @SerializedName("posted_by")
    val postedBy: User,

    @SerializedName("weight")
    val weight: Double,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("id")
    val id: String,

    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,

    @SerializedName("created_at")
    val postedAt: String
) : Parcelable