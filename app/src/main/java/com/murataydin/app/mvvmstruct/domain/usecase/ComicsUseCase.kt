package com.murataydin.app.mvvmstruct.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.faskn.app.weatherapp.utils.domain.Resource
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import com.murataydin.app.mvvmstruct.repo.HomeRepository
import com.murataydin.app.mvvmstruct.ui.main.home.HomeViewState
import com.murataydin.app.mvvmstruct.utils.UseCaseLiveData
import javax.inject.Inject


class ComicsUseCase @Inject internal constructor(private val repository: HomeRepository)  {


    fun getAllComicList() = repository.getAllComicList()

}
