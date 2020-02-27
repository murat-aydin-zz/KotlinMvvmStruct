package com.murataydin.app.mvvmstruct.repo

import NetworkBoundResource
import androidx.lifecycle.LiveData
import com.murataydin.app.mvvmstruct.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity
import com.murataydin.app.mvvmstruct.domain.dataSource.ComicsLocaleDataSource
import com.murataydin.app.mvvmstruct.domain.dataSource.ComicsRemoteDataSource
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.utils.domain.Resource
import com.murataydin.app.mvvmstruct.utils.extensions.applyLoading
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class HomeRepository @Inject constructor(
        private val comicsDataSource: ComicsRemoteDataSource,
        private val comicsLocaleDataSource: ComicsLocaleDataSource) {

    fun getAllComicList(): LiveData<Resource<ComicsEntity>> {
        return object : NetworkBoundResource<ComicsEntity, Comics>() {

            override fun createCall(): Single<Comics> = comicsDataSource.getAllComicList()

            override fun saveCallResult(item: Comics) {
                comicsLocaleDataSource.insertComic(item)
            }
            override fun onFetchFailed() {
                Timber.d("HATA OLDU")
            }
            override fun loadFromDb(): LiveData<ComicsEntity> = comicsLocaleDataSource.getComics()
            override fun shouldFetch(data: ComicsEntity?): Boolean = true
        }.asLiveData
    }

}