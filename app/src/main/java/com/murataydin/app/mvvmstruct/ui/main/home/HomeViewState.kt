package com.murataydin.app.mvvmstruct.ui.main.home

import com.murataydin.app.mvvmstruct.utils.domain.Status
import com.murataydin.app.mvvmstruct.domain.response.Comics


class HomeViewState(
        val status: Status,
        val error: Throwable? = null,
        val data: Comics? = null
)  {
    fun getComics() = data?.data
    fun isLoading() = status == Status.LOADING
    fun isSuccess() = status == Status.SUCCESS

}
