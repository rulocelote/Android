package com.sem.empresasappandcmal.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.sem.empresasappandcmal.R
import java.text.SimpleDateFormat
import java.util.*

fun EditText.textWatcher(valida: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {valida(s.toString())}
    })
}

//FUNCION ENCARGADA DE OBTENER LA FECHA ACTUAL DEL DISPOSITIVO
@SuppressLint("SimpleDateFormat")
fun obtenerFecha():String{
    val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm")
    val currentDate = sdf.format(Date())
    return currentDate
}

fun Context.alertDialog(
    title:String,
    message:String,
    positiveText:String = getString(R.string.btn_aceptar),
    neutralText:String? = null,
    positive: (() -> Unit)? = null,
    neutral: (() -> Unit)? = null){

    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    message.let{builder.setMessage(it)}

    positiveText?.let{
        builder.setPositiveButton(it){ _, _ ->
            positive?.let { it() }
        }
    }

    neutralText.let{
        builder.setNeutralButton(it){ _, _ ->
            neutral?.let { it() }
        }
    }

    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}