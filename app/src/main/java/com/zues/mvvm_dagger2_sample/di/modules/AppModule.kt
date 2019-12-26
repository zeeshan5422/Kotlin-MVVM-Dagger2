package com.zues.mvvm_dagger2_sample.di.modules

import android.content.Context
import com.zues.mvvm_dagger2_sample.MyApplication
import com.zues.mvvm_dagger2_sample.data.network.MyApi
import com.zues.mvvm_dagger2_sample.data.repository.UserRepository
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import com.zues.mvvm_dagger2_sample.db.UserDao
import com.zues.mvvm_dagger2_sample.di.ApplicationContext
import dagger.Module
import dagger.Provides

/* ---  Created by akhtarz on 12/17/2019. ---*/
@Module
class AppModule(val myApplication: MyApplication) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = myApplication.applicationContext

    @Provides
    fun provideApplication() = myApplication

    @Provides
    fun provideUserRepository(myApi: MyApi, db: AppDatabase) = UserRepository(myApi,db)
}