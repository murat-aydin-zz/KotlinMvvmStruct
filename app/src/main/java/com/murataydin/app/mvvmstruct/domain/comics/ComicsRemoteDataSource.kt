package com.murataydin.app.mvvmstruct.domain.comics

import com.murataydin.app.mvvmstruct.domain.AppAPI
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ComicsRemoteDataSource @Inject constructor(private val api: AppAPI) {

    fun getAllComicList() = api.getComics()

}
