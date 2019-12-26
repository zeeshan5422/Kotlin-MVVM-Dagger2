package com.zues.mvvm_dagger2_sample.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zues.mvvm_dagger2_sample.MyApplication
import com.zues.mvvm_dagger2_sample.R
import com.zues.mvvm_dagger2_sample.databinding.ActivityLoginBinding
import com.zues.mvvm_dagger2_sample.db.entities.User
import com.zues.mvvm_dagger2_sample.di.components.ActivityComponent
import com.zues.mvvm_dagger2_sample.di.components.DaggerActivityComponent
import com.zues.mvvm_dagger2_sample.di.modules.ActivityModule
import com.zues.mvvm_dagger2_sample.ui.main.MainActivity
import com.zues.mvvm_dagger2_sample.utils.hide
import com.zues.mvvm_dagger2_sample.utils.show
import com.zues.mvvm_dagger2_sample.utils.snackbar
import com.zues.mvvm_dagger2_sample.utils.toast
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/* ---  Created by akhtarz on 12/17/2019. ---*/
class LoginActivity : AppCompatActivity(), AuthListener {

    @Inject
    lateinit var factory: AuthViewModelFactory

    var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (activityComponent == null) {
            activityComponent =
                DaggerActivityComponent
                    .builder()
                    .activityModule(ActivityModule(this))
                    .appComponent((application as MyApplication).appComponent)
                    .build()
        }
        activityComponent?.inject(this)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            user?.let {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        root_layout.snackbar("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        toast(message)
        progress_bar.hide()
    }
}