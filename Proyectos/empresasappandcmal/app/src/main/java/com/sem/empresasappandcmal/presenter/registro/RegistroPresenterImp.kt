package com.sem.empresasappandcmal.presenter.registro

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.model.registro.RegistroModel
import com.sem.empresasappandcmal.model.registro.RegistroModelImp
import com.sem.empresasappandcmal.utils.*
import com.sem.empresasappandcmal.view.registro.RegistroActivity
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class RegistroPresenterImp(private val registroView:RegistroActivity):RegistroPresenter {

    private val registroModel:RegistroModel = RegistroModelImp(this)

    override fun enviarDatos(numEmpleado:String, name:String, apPaterno:String, apMaterno:String, fechaNacimiento:String, telefono:String, correo:String, pass:String, foto:String) {
        registroView.showProgres()
        registroModel.validaRegistro(numEmpleado, name, apPaterno, apMaterno, fechaNacimiento, telefono, correo, pass, foto)
    }

    override fun retornaRespuesta(codigo: String, descripcion:String) {
        registroView.hideProgres()
        when(codigo){
            Constants.IDE_ONE -> registroView.onRegistroSucces(descripcion)
            Constants.IDE_FOUR -> registroView.onFailConexionError(descripcion)
            Constants.IDE_FIVE -> registroView.onFailIdExist(descripcion)
        }
    }

    override fun onFailConection() {
        registroView.hideProgres()
        registroView.onFailConexionError(registroView.applicationContext.getString(R.string.error_conexion))
    }

    //Funcion encargada de solicitar permisos de camara, almacenamiento y ubicacion
    override fun permisos(context: Context): Boolean {
        return if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            registroView.let { ActivityCompat.requestPermissions(it, arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            false
        } else true
    }

    //FUncion encargada de bajar la resolucion a la fotografia para poder enviarla
    override fun encoderPicture(path:String):String {
        val fotoBitmap = resizeBitmap(path,500,500)
        val foto = fotoBitmap?.let { BitMapToString(it) }.toString()
        return foto
    }

    //FUNCION ENCARGADA DE ABRIR LA APLICACION DE LA CAMARA PARA TOMAR LA FOTOGRAFIA
    override fun dispatchTakePictureIntent(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(registroView.applicationContext.packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        registroView.applicationContext,
                        "com.sem.empresasappandcmal",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    registroView.startActivityForResult(takePictureIntent, 1)
                }
            }
        }
    }

    //FUNCION ENCARGADA DE GUARDAR LA F0TOGRAFIA EN UNA RUTA Y ASIGNARLE UN NOMBRE UNICO
    override fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = registroView.applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "ASISTENCIA_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            RegistroActivity.path = absolutePath
        }
    }
}