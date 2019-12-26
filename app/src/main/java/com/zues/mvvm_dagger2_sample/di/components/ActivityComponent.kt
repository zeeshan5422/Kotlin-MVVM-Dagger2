package com.zues.mvvm_dagger2_sample.di.components

import com.zues.mvvm_dagger2_sample.di.PerActivity
import com.zues.mvvm_dagger2_sample.di.modules.ActivityModule
import com.zues.mvvm_dagger2_sample.ui.auth.LoginActivity
import dagger.Component
import javax.inject.Singleton

/* ---  Created by akhtarz on 12/17/2019. ---*/
@PerActivity
@Component(
    dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(ActivityModule::class)
)
public interface ActivityComponent {

    fun inject(loginActivity: LoginActivity)

}