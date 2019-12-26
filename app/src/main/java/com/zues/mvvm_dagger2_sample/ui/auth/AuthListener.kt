package com.zues.mvvm_dagger2_sample.ui.auth

import androidx.lifecycle.LiveData
import com.zues.mvvm_dagger2_sample.db.entities.User

/* ---  Created by akhtarz on 12/3/2019. ---*/
interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}