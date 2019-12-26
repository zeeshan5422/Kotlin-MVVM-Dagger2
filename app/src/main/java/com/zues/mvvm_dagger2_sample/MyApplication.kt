package com.zues.mvvm_dagger2_sample

import android.app.Application
import android.content.Context
import com.zues.mvvm_dagger2_sample.data.DataManager
import com.zues.mvvm_dagger2_sample.di.components.AppComponent
import com.zues.mvvm_dagger2_sample.di.components.DaggerAppComponent
import com.zues.mvvm_dagger2_sample.di.modules.AppModule
import com.zues.mvvm_dagger2_sample.di.modules.DBModule
import com.zues.mvvm_dagger2_sample.di.modules.NetworkModule
import javax.inject.Inject

/* ---  Created by akhtarz on 12/16/2019. ---*/
class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var dataManager : DataManager

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule())
            .appModule(AppModule(this))
            .dBModule(DBModule(this))
            .build()
        appComponent.inject(this)
    }

    companion object {
        fun get(context: Context) = context.applicationContext
    }



}