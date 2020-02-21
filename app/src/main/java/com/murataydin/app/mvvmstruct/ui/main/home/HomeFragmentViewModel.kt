package com.murataydin.app.mvvmstruct.ui.main.home

import android.content.SharedPreferences
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
    val dummyComicLiveData = MutableLiveData<HomeViewState>()


    fun getAllComicList() {
        comicsUseCase
                .getAllComicList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetComicResultReady)
                .also { disposable += it }
    }

    private fun onGetComicResultReady(resource: Resource<Comics>) {
        dummyComicLiveData.value = HomeViewState(
                status = resource.status,
                error = resource.error,
                data = resource.data
        )
    }
}
