package com.murataydin.app.mvvmstruct

import android.app.Activity
import android.app.Application
import android.os.Build
import com.facebook.stetho.Stetho
import com.faskn.app.weatherapp.di.AppInjector
import com.jakewharton.threetenabp.AndroidThreeTen
import com.murataydin.app.mvvmstruct.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)
    }

}
