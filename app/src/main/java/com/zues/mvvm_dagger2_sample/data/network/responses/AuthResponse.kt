package com.zues.mvvm_dagger2_sample.data.network.responses

import com.zues.mvvm_dagger2_sample.db.entities.User

/* ---  Created by akhtarz on 12/4/2019. ---*/
data class AuthResponse (val isSuccessful: Boolean?,
                         val message: String?,
                         val user: User?)