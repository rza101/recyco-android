package com.ukmprogramming.recyco.data.network.response.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class MarketTransactionItem(
    @SerializedName("item")
    val item: MarketItem,

    @SerializedName("id")
    val id: String,

    @SerializedName("all_status")
    val allStatus: List<MarketTransactionStatusModel>
) : Parcelable