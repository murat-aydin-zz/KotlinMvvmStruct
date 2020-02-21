package com.murataydin.app.mvvmstruct.domain.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataItem(
        @Json(name = "image")

        val image: String? = null,

        @Json(name = "category_id")
        val categoryId: String? = null,

        @Json(name = "like")
        val like: Int? = null,

        @Json(name = "like_result")
        var likeResult: Boolean? = false,

        @Json(name = "artist_name")
        val artistName: String? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "category_name")
        val categoryName: String? = null,

        @Json(name = "artist_id")
        val artistId: String? = null
)