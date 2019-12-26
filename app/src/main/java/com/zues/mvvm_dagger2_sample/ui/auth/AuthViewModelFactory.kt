package com.zues.mvvm_dagger2_sample.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zues.mvvm_dagger2_sample.data.repository.UserRepository
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import javax.inject.Inject

/* ---  Created by akhtarz on 12/17/2019. ---*/
class AuthViewModelFactory @Inject constructor(val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}