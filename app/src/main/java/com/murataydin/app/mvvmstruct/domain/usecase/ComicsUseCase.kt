package com.murataydin.app.mvvmstruct.domain.usecase

import com.murataydin.app.mvvmstruct.repo.HomeRepository
import javax.inject.Inject


class ComicsUseCase @Inject internal constructor(private val repository: HomeRepository)  {


    fun getAllComicList() = repository.getAllComicList()

}
