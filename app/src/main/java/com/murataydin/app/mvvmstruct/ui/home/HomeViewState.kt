package com.murataydin.app.mvvmstruct.ui.home

import com.murataydin.app.mvvmstruct.core.BaseViewState
import com.murataydin.app.mvvmstruct.db.entities.ComicsEntity
import com.murataydin.app.mvvmstruct.domain.response.Comics
import com.murataydin.app.mvvmstruct.utils.domain.Status

class HomeViewState(
        val status: Status,
        val error: Throwable? = null,
        val data: ComicsEntity? = null
) : BaseViewState(status, error) {
    fun getComics() = data
}
