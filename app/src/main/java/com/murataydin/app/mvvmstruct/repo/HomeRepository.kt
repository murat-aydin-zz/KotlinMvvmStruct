package com.murataydin.app.mvvmstruct.repo

import com.murataydin.app.mvvmstruct.domain.dataSource.ComicsRemoteDataSource
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.utils.domain.Resource
import com.murataydin.app.mvvmstruct.utils.extensions.applyLoading
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeRepository @Inject constructor(
        private val comicsDataSource: ComicsRemoteDataSource) {

    fun getAllComicList(): Observable<Resource<Comics>> = comicsDataSource
            .getAllComicList()
            .map { Resource.success(it) }
            .onErrorReturn { Resource.error(it) }
            .subscribeOn(Schedulers.io())
            .compose(applyLoading())

}
