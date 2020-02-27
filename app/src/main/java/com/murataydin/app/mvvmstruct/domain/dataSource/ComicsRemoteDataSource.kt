package com.murataydin.app.mvvmstruct.domain.dataSource

import com.murataydin.app.mvvmstruct.domain.AppAPI
import com.murataydin.app.mvvmstruct.domain.response.Comics
import io.reactivex.Single
import javax.inject.Inject

class ComicsRemoteDataSource @Inject constructor(private val api: AppAPI) {

    fun getAllComicList(): Single<Comics> = api.getComics()

}
