package com.zues.mvvm_dagger2_sample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.zues.mvvm_dagger2_sample.data.repository.UserRepository
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import com.zues.mvvm_dagger2_sample.utils.ApiException
import com.zues.mvvm_dagger2_sample.utils.Coroutines
import com.zues.mvvm_dagger2_sample.utils.NoInternetException
import javax.inject.Inject

/* ---  Created by akhtarz on 12/17/2019. ---*/
class AuthViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid username or password")
            return
        }

        Coroutines.main {
            try {

                val authResponse = repository.userLogin(email!!, password!!)

                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    // save user in database
                    repository.saveUser(it)

                }

                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

}