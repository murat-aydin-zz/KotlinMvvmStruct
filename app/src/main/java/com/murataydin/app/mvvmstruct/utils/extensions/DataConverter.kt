package com.murataydin.app.mvvmstruct.utils.extensions

import androidx.room.TypeConverter
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


object DataConverter {

    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<DataItem>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, DataItem::class.java)
        val adapter = moshi.adapter<List<DataItem>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<DataItem>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, DataItem::class.java)
        val adapter = moshi.adapter<List<DataItem>>(type)
        return adapter.toJson(objects)
    }

}
