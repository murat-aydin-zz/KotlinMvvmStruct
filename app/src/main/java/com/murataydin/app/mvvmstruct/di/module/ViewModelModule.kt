package com.murataydin.app.mvvmstruct.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faskn.app.weatherapp.di.key.ViewModelKey
import com.murataydin.app.mvvmstruct.di.ViewModelFactory
import com.murataydin.app.mvvmstruct.ui.main.MainActivityViewModel
import com.murataydin.app.mvvmstruct.ui.main.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun provideHomeFragmentViewModel(homeFragmentViewModel: HomeFragmentViewModel): ViewModel

}
