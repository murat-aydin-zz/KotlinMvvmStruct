package com.murataydin.app.mvvmstruct.ui.main

import androidx.databinding.ObservableField
import com.murataydin.app.mvvmstruct.core.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject internal constructor() : BaseViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}