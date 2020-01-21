package com.sem.empresasappandcmal.presenter.perfil

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.data.perfil.ListaAsistencia
import com.sem.empresasappandcmal.model.perfil.PerfilModel
import com.sem.empresasappandcmal.model.perfil.PerfilModelImp
import com.sem.empresasappandcmal.model.realm.RealmUtils
import com.sem.empresasappandcmal.utils.Constants
import com.sem.empresasappandcmal.utils.decoder
import com.sem.empresasappandcmal.utils.rotationPhoto
import com.sem.empresasappandcmal.view.perfil.PerfilFragment
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class PerfilPresenterImp(internal val view:PerfilFragment): PerfilPresenter {

    private val perfilModel:PerfilModel = PerfilModelImp(this)

    override fun enviarAsistencia(numEmpleado: String){
        view.showProgres()
        perfilModel.recuperarAsistencia(numEmpleado)
    }

    override fun enviarDatos(numEmpleado: String) {
        view.showProgres()
        val realmUtils = RealmUtils.realmUser(view.context!!)
        val user = realmUtils.obtenerUsuario()

        if(user != null){
            view.hideProgres()
            view.requestDatos(user.numEmpleado,user.nombre,user.apellido,user.foto)
        }
        else{
            view.hideProgres()
            perfilModel.recuperarDatos(numEmpleado)
        }
    }

    override fun requestAsistencia(codigoOperacion: String, descripcion: String, listaAsistencia: ArrayList<ListaAsistencia>) {
        view.hideProgres()
        when(codigoOperacion){
            Constants.IDE_ONE -> view.requestSucces(listaAsistencia)
            Constants.IDE_FOUR -> view.requestFail(descripcion)
        }
    }

    override fun requestData(idEmpleado: String, nombre: String, apellido: String, foto: String) {
        view.hideProgres()
        val realmUtils = RealmUtils.realmUser(view.context!!)
        realmUtils.crearUsuario(idEmpleado,nombre,apellido,foto)
        view.requestDatos(idEmpleado,nombre,apellido,foto)
    }

    override fun requestFail() {
        view.hideProgres()
        view.failConexion()
    }

    override fun comparaHora(hora: String): String {
        val format = SimpleDateFormat("HH:mm", Locale.ROOT)
        var descripcion = ""
        if(format.parse(hora) > format.parse("10:00"))
            descripcion = view.getString(R.string.retardo)

        return descripcion
    }

    override fun permisos(context: Context): Boolean {
        return if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            view.let { ActivityCompat.requestPermissions(view.activity!!, arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION), 1000)
            }
            false
        } else true
    }

    override fun mostrarAsistencia(dia:String, mes:String, anio:String, asistencia: ArrayList<ListaAsistencia>){
        val dias = if(dia.length == 1) "0$dia" else dia
        val meses = if(mes.length == 1) "0$mes" else mes
        val fecha = "$dias-$meses-$anio"//formato de fecha retornado por servicios
        val mostrafecha = "$dias/$meses/$anio"//formato de fecha para mostrar al usuario
        val fechaAsistencia:ArrayList<String> = ArrayList()
        val hora:MutableMap<String,String> = mutableMapOf<String,String>()

        asistencia.forEach {
            fechaAsistencia.add(it.fechaAsistencia.substring(0,10))
            hora.put(it.fechaAsistencia.substring(0,10),it.fechaAsistencia.substring(11))
        }

        if(fechaAsistencia.contains(fecha))
            view.asistenciaRegistrada(mostrafecha, hora[fecha]!!)
        else
            view.sinAsistencia(mostrafecha)
    }

    override fun decoderImage(foto:String):RoundedBitmapDrawable {
        val decodeImage = decoder(foto)
        val rotation = rotationPhoto(decodeImage)
        val roundedDrawable: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(view.resources, rotation)

        roundedDrawable.cornerRadius = rotation.getHeight().toFloat()
        return roundedDrawable
    }

    override fun confirmacionEnviarAsistencia(numEmpleado: String, encoder:String,fechaAsitencia:String,latitud:Double,lontigutd:Double) {
        view.showProgres()
        perfilModel.registraAsistencia(numEmpleado,encoder,fechaAsitencia,latitud,lontigutd)
    }

    override fun requestFailAsistencia() {
        view.hideProgres()
        view.requestFail(view.getString(R.string.error_conexion))
    }

    override fun asistenciaRequest(descripcion:String){
        view.hideProgres()
        view.requestAsistencia(descripcion)
    }

    //FUNCIONES ENCARGADA DE OBTENER LA UBICACION ACTUAL DEL DISPOSITIVO
    @SuppressLint("MissingPermission")
    override fun proveedorLocation(){
        var locationGps: Location? = null
        var locationNetwork: Location? = null

        val locationManager = view.context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (hasGps || hasNetwork) {
            if (hasGps) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0F, object :
                    LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationGps = location
                            view.latitud = locationGps!!.latitude
                            view.longitud = locationGps!!.longitude
                        }
                    }
                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
                    override fun onProviderEnabled(provider: String?) {}
                    override fun onProviderDisabled(provider: String?) {}
                })

                val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (localGpsLocation != null)
                    locationGps = localGpsLocation
            }
            if (hasNetwork) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0F, object :
                    LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationNetwork = location
                            view.latitud = locationNetwork!!.latitude
                            view.longitud = locationNetwork!!.longitude
                        }
                    }
                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
                    override fun onProviderEnabled(provider: String?) {}
                    override fun onProviderDisabled(provider: String?) {}
                })

                val localNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }

            if(locationGps!= null && locationNetwork!= null){
                if(locationGps!!.accuracy > locationNetwork!!.accuracy){
                    view.latitud = locationNetwork!!.latitude
                    view.longitud = locationNetwork!!.longitude
                }else{
                    view.latitud = locationGps!!.latitude
                    view.longitud = locationGps!!.longitude
                }
            }
            dispatchTakePictureIntent()
        }else {
            view.context!!.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
    }

    //FUNCION ENCARGADA DE ABRIR LA APLICACION DE LA CAMARA PARA TOMAR LA FOTOGRAFIA
    fun dispatchTakePictureIntent(){
        val REQUEST_TAKE_PHOTO = 1
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(view.context!!.packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        view.context!!,
                        "com.sem.empresasappandcmal",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    view.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    //FUNCION ENCARGADA DE GUARDAR LA F0TOGRAFIA EN UNA RUTA Y ASIGNARLE UN NOMBRE UNICO
    fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = view.context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "ASISTENCIA_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            view.path = absolutePath
        }
    }
}