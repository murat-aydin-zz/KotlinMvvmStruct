package com.murataydin.app.mvvmstruct.core

import com.murataydin.app.mvvmstruct.utils.domain.Status

/**
 * Created by Furkan on 2020-02-21
 */


open class BaseViewState(val baseStatus: Status, val baseError: Throwable?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}