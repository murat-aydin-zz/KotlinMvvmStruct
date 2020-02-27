package com.murataydin.app.mvvmstruct.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.murataydin.app.mvvmstruct.db.dao.ComicsDao
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity
import com.murataydin.app.mvvmstruct.utils.extensions.DataConverter

@Database(
    entities = [
        ComicsEntity::class
    ],
    version = 3
)

@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicsDao(): ComicsDao

}
