package com.zues.mvvm_dagger2_sample.di.modules

import android.app.Activity
import android.content.Context
import com.zues.mvvm_dagger2_sample.MyApplication
import com.zues.mvvm_dagger2_sample.data.repository.UserRepository
import com.zues.mvvm_dagger2_sample.di.ActivityContext
import com.zues.mvvm_dagger2_sample.di.ApplicationContext
import com.zues.mvvm_dagger2_sample.ui.auth.AuthViewModelFactory
import dagger.Module
import dagger.Provides

/* ---  Created by akhtarz on 12/17/2019. ---*/
@Module
class ActivityModule(val mActivity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = mActivity

    @Provides
    fun provideActivity() = mActivity

    @Provides
    fun provideAuthViewModelfactory(userRepository: UserRepository) = AuthViewModelFactory(userRepository)
}