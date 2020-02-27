package com.murataydin.app.mvvmstruct.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.murataydin.app.mvvmstruct.core.BaseViewModel
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.domain.usecase.ComicsUseCase
import com.murataydin.app.mvvmstruct.utils.domain.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject


class HomeFragmentViewModel @Inject internal constructor(private val comicsUseCase: ComicsUseCase) : BaseViewModel() {

    private val _dummyComicLiveData: MutableLiveData<HomeViewState> = MutableLiveData()
    val dummyComicLiveData: LiveData<HomeViewState> = _dummyComicLiveData
    private val _comicsParams: MutableLiveData<ComicsUseCase.ComicsParams> = MutableLiveData()

    fun getComicsViewState() = comicsViewState

    private val comicsViewState: LiveData<HomeViewState> = _comicsParams.switchMap { params ->
        comicsUseCase.execute(params)
    }


    /*fun getAllComicList() {
        comicsUseCase
                .getAllComicList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetComicResultReady)
                .also { disposable += it }
    }

    private fun onGetComicResultReady(resource: Resource<Comics>) {
        _dummyComicLiveData.value = HomeViewState(
                status = resource.status,
                error = resource.error,
                data = resource.data
        )
    }
*/
    fun setComicsParams(params: ComicsUseCase.ComicsParams) {
        if (_comicsParams.value == params)
            return
        _comicsParams.postValue(params)
    }
}
