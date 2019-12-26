package com.zues.mvvm_dagger2_sample.ui.main.profile

import androidx.lifecycle.ViewModel
import com.zues.mvvm_dagger2_sample.data.repository.UserRepository

/* ---  Created by akhtarz on 12/17/2019. ---*/
class ProfileViewModel(repository : UserRepository) : ViewModel() {

    val user = repository
}