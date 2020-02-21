package com.murataydin.app.mvvmstruct.di.module

import com.murataydin.app.mvvmstruct.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

   @ContributesAndroidInjector
   abstract fun contributeHomeFragment(): HomeFragment

}
