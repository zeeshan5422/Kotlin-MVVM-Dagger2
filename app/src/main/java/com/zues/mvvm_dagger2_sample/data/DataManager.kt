package com.zues.mvvm_dagger2_sample.data

import android.content.Context
import android.widget.Toast
import com.zues.mvvm_dagger2_sample.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/* ---  Created by akhtarz on 12/17/2019. ---*/
@Singleton
class DataManager @Inject constructor(@ApplicationContext val context: Context) {

    fun showT(){
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
    }
}