package com.murataydin.app.mvvmstruct.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import com.murataydin.app.mvvmstruct.repo.HomeRepository
import com.murataydin.app.mvvmstruct.ui.home.HomeViewState
import com.murataydin.app.mvvmstruct.utils.UseCaseLiveData
import com.murataydin.app.mvvmstruct.utils.domain.Resource
import io.reactivex.Observable
import javax.inject.Inject


class ComicsUseCase @Inject internal constructor(private val repository: HomeRepository) : UseCaseLiveData<HomeViewState, ComicsUseCase.ComicsParams, HomeRepository>() {


    class ComicsParams() : Params()


    override fun getRepository(): HomeRepository {
        return repository
    }

    private fun onComicsResultReady(resource: Resource<ComicsEntity>): HomeViewState {

        return HomeViewState(
                status = resource.status,
                error = resource.error,
                data = resource.data
        )
    }

    override fun buildUseCaseObservable(params: ComicsParams?): LiveData<HomeViewState> {
        return repository.getAllComicList().map {

           onComicsResultReady(it)
        }
    }
}
