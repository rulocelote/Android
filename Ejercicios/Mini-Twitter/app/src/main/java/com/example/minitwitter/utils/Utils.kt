package com.example.minitwitter.utils

import android.app.AlertDialog
import android.content.Context

fun Context.alertDialog(
    title:String,
    message:String,
    positiveText:String = "",
    negativeString:String = "",
    postive: (() -> Unit)? = null,
    negative: (() -> Unit)? = null
){
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveText){_,_ -> postive }
    builder.setNeutralButton(negativeString){_,_ -> negative}

    val alertDialog:AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}