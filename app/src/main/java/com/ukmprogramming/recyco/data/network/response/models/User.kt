package com.ukmprogramming.recyco.data.network.response.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class User(
    @SerializedName("role")
    val role: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("phone_number")
    val phoneNumber: String,

    @SerializedName("id")
    val id: String
) : Parcelable