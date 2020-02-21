package com.murataydin.app.mvvmstruct.utils.extensions

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import android.widget.Toast

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, duration).show()

inline fun Activity.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder): AlertDialog {
    return AlertDialog.Builder(this)
            .body()
            .show()
}