package com.murataydin.app.mvvmstruct.domain.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comics(

        @Json(name = "data")
        val data: List<DataItem?>? = null
)