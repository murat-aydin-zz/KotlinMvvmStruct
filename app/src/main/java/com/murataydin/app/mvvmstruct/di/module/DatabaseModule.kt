package com.murataydin.app.mvvmstruct.di.module

import android.content.Context
import androidx.room.Room
import com.murataydin.app.mvvmstruct.db.AppDatabase
import com.murataydin.app.mvvmstruct.db.dao.ComicsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "comics-db").build()
    }

    @Singleton
    @Provides
    fun provideComicsDao(db: AppDatabase): ComicsDao {
        return db.comicsDao()
    }
}