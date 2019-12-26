package com.zues.mvvm_dagger2_sample.di.modules

import android.content.Context
import androidx.room.Room
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import com.zues.mvvm_dagger2_sample.db.UserDao
import com.zues.mvvm_dagger2_sample.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/* ---  Created by akhtarz on 12/20/2019. ---*/
@Module
class DBModule(context: Context) {
    var appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "MyDatabase.db"
    ).build()

    @Provides
    @Singleton
    fun provideDBInstance() = appDatabase

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.getUserDao()
}