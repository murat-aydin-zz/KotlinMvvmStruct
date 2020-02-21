package com.murataydin.app.mvvmstruct.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.murataydin.app.mvvmstruct.App
import com.murataydin.app.mvvmstruct.di.module.*
import com.murataydin.app.mvvmstruct.ui.main.MainActivityViewModel
import dagger.BindsInstance

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            NetModule::class,
            DatabaseModule::class,
            ActivityModule::class,
            ViewModelModule::class
        ]
)


interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
