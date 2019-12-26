package com.zues.mvvm_dagger2_sample.di.components

import com.zues.mvvm_dagger2_sample.MyApplication
import com.zues.mvvm_dagger2_sample.data.network.MyApi
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import com.zues.mvvm_dagger2_sample.db.UserDao
import com.zues.mvvm_dagger2_sample.di.modules.AppModule
import com.zues.mvvm_dagger2_sample.di.modules.DBModule
import com.zues.mvvm_dagger2_sample.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

/* ---  Created by akhtarz on 12/17/2019. ---*/
@Singleton
@Component(modules = arrayOf(NetworkModule::class, AppModule::class, DBModule::class))
public interface AppComponent {

    fun inject(myApplication: MyApplication)

    fun getMyApi(): MyApi

    fun getUserDao(): UserDao

    fun getAppDatabase(): AppDatabase

}