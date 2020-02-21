package com.murataydin.app.mvvmstruct.di.module

import com.murataydin.app.mvvmstruct.di.scope.PerActivity
import com.murataydin.app.mvvmstruct.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    /**
     * Injects [MainActivity]
     *
     * @return an instance of [MainActivity]
     */

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity
}
