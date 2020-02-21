package com.murataydin.app.mvvmstruct.ui.main.home

import com.faskn.app.weatherapp.utils.domain.Status
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.domain.response.DataItem

/**
 * Created by Furkan on 2019-10-23
 */

class HomeViewState(
        val status: Status,
        val error: Throwable? = null,
        val data: Comics? = null
)  {
    fun getComics() = data?.data
    fun isLoading() = status == Status.LOADING
    fun isSuccess() = status == Status.SUCCESS

}
