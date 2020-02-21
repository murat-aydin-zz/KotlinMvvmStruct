package com.murataydin.app.mvvmstruct.domain.dataSource

import com.murataydin.app.mvvmstruct.domain.AppAPI
import javax.inject.Inject

class ComicsRemoteDataSource @Inject constructor(private val api: AppAPI) {

    fun getAllComicList() = api.getComics()

}
