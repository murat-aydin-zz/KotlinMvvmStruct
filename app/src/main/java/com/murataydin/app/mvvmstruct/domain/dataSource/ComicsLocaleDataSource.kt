package com.murataydin.app.mvvmstruct.domain.dataSource

import com.murataydin.app.mvvmstruct.db.dao.ComicsDao
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity
import com.murataydin.app.mvvmstruct.domain.AppAPI
import com.murataydin.app.mvvmstruct.domain.response.Comics
import io.reactivex.Single
import javax.inject.Inject

class ComicsLocaleDataSource @Inject constructor(private val comicsDao: ComicsDao) {

    fun getComics()= comicsDao.getComics()
    fun insertComic(comics: Comics) = comicsDao.deleteAndInsert(ComicsEntity(comics))

}
