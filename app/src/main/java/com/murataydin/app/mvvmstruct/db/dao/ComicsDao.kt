package com.murataydin.app.mvvmstruct.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity

@Dao
interface ComicsDao {

    @Query("SELECT * FROM Comics")
    fun getComics(): LiveData<ComicsEntity>

    @Insert(onConflict = REPLACE)
    fun insertComics(comics: ComicsEntity)

    @Transaction
    fun deleteAndInsert(comics: ComicsEntity) {
        deleteAll()
        insertComics(comics)
    }

    @Update
    fun updateComics(comics: ComicsEntity)

    @Delete
    fun deleteComics(comics: ComicsEntity)

    @Query("DELETE FROM Comics")
    fun deleteAll()

    @Query("Select count(*) from Comics")
    fun getCount(): Int
}
