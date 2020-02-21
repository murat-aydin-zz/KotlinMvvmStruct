package com.murataydin.app.mvvmstruct.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.murataydin.app.mvvmstruct.db.dao.ExampleDao
import com.murataydin.app.mvvmstruct.db.entities.Example

@Database(entities = arrayOf(Example::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}