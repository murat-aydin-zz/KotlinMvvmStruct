package com.murataydin.app.mvvmstruct.domain.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Comics(

        @Json(name = "data")
        val data: List<DataItem?>? = null
) : Parcelable