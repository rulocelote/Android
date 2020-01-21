package com.sem.empresasappandcmal.utils

import android.util.Patterns
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.sem.empresasappandcmal.R
import java.util.regex.Pattern

fun EditText.validaVacios():Boolean{
    return this.text.toString().trim().isNotEmpty()
}

fun TextInputLayout.validaLong(texto:EditText,long:Int):Boolean {
    val validacion = texto.text.toString().trim().length == long
    if(validacion) this.error = ""
    else this.error = this.context.getString(R.string.long_campos,long)
    return validacion
}

fun TextInputLayout.validaCorreo(correo: EditText): Boolean {
    val validacion =  Patterns.EMAIL_ADDRESS.matcher(correo.text.toString().trim()).matches()
    if(validacion) this.error = ""
    else this.error = this.context.getString(R.string.correo_no_valido)
    return validacion
}

fun TextInputLayout.validaPassword(password:EditText):Boolean{
    val pattern: Pattern = Pattern.compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c\\u002E\\u002D\\u002F\\u003A\\u003B\\u003D\\u003E\\u003F\\u0040\\u005B\\u005C\\u005D\\u005E\\u005F\\u0060\\u007B\\u007C\\u007D\\u007E\\u00F7\t])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}\$")
    val validacion = pattern.matcher(password.text.toString().trim()).matches()
    if(validacion) this.error = ""
    else this.error = this.context.getString(R.string.error_password)
    return validacion
}

fun TextInputLayout.matchPassword(password: EditText, passwordConfirm:EditText):Boolean {
    val validacion = password.text.toString().trim() == passwordConfirm.text.toString().trim()

    if (validacion) this.error = ""
    else this.error = this.context.getString(R.string.error_pass_no_match)
    return validacion
}