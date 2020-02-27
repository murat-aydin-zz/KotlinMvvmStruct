package com.murataydin.app.mvvmstruct.db.entities

import android.os.Parcelable
import androidx.room.*
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import kotlinx.android.parcel.Parcelize



@Parcelize
@Entity(tableName = "Comics")
data class ComicsEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "data")
    var data: List<DataItem>?

) : Parcelable{

    @Ignore
    constructor(comics: Comics) : this(
            id = 0,
            data = comics.data as List<DataItem>?
    )
}
