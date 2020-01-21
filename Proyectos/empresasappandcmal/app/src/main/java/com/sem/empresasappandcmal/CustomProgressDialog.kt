package com.sem.empresasappandcmal

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.ProgressBar

class CustomProgressDialog() {

    private lateinit var mDialog: Dialog

    constructor(context: Context) : this() {

        mDialog = Dialog(context)
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(R.layout.custom_progress_dialog)
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mProgressBar = mDialog.findViewById<ProgressBar>(R.id.progressBar)
        mProgressBar.isIndeterminate = true

        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)
    }

    fun showCustomProgressDialog() {
        mDialog.show()
    }

    fun dismissCustomProgressDialog() {
        mDialog.dismiss()
    }

}