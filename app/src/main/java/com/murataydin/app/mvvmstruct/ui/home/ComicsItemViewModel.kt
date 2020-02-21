package com.murataydin.app.mvvmstruct.ui.home

import androidx.databinding.ObservableField
import com.murataydin.app.mvvmstruct.core.BaseViewModel
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import javax.inject.Inject

class ComicsItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<DataItem>()
}
