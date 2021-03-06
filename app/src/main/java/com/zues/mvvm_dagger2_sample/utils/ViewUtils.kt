package com.zues.mvvm_dagger2_sample.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/* ---  Created by akhtarz on 12/19/2019. ---*/


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}
fun ProgressBar.hide() {
    visibility = View.GONE
}

fun View.snackbar(message: String){
    Snackbar.make(this, message,Snackbar.LENGTH_SHORT).also { snackbar ->
        snackbar.setAction("Ok"){
            snackbar.dismiss()
        }
    }.show()
}