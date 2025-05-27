package com.ukmprogramming.recyco.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.ukmprogramming.recyco.data.network.response.models.ForumPost

@Keep
data class ForumPostsResponse(
    @field:SerializedName("data")
    val data: List<ForumPost>? = null,

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
