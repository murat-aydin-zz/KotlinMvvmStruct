package com.murataydin.app.mvvmstruct.utils

import androidx.lifecycle.LiveData
import com.murataydin.app.mvvmstruct.ui.home.HomeViewState
import io.reactivex.Observable

/**
 * Created by Furkan on 2019-10-21
 */

abstract class UseCaseLiveData<M, P, R> {

    abstract fun getRepository(): R

    abstract fun buildUseCaseObservable(params: P?): LiveData<HomeViewState>

    /**
     * Executes the target call
     *
     * @param params represents params to be passed
     * @return [Disposable] result
     */

    fun execute(params: P?): LiveData<HomeViewState> {
        return buildUseCaseObservable(params)
    }

    abstract class Params

    class None
}
