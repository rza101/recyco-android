package com.ukmprogramming.recyco.data.network.response.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class LoginData(
    @SerializedName("token")
    val token: String
) : Parcelable