package com.example.demoapichofer

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import android.location.Criteria as Criteria1

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener {

    private lateinit var mMap: GoogleMap
    var version = Build.VERSION.SDK_INT
    var permisosGps = false
    val SEGUNDOS = 3
    val TIEMPO_MIN:Long = (SEGUNDOS*1000).toLong()
    val DISTANCIA_MIN = 3f
    val ZOOM_DEFAUTL = 19f

    lateinit var ultimaUbicacion:Location
    lateinit var manejador:LocationManager
    lateinit var marcadorActualOptions:MarkerOptions
    lateinit var marcadorActual:Marker
    lateinit var provedor:String


    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if(version>=Build.VERSION_CODES.M){
            verificaPermisos()
        }

        if(permisosGps){
            manejador = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val criterio = Criteria1()
            criterio.isCostAllowed = false
            criterio.isAltitudeRequired = false
            criterio.accuracy = Criteria1.ACCURACY_FINE

            provedor = manejador.getBestProvider(criterio,true)
            mostrarMensaje("Provedor = $provedor")

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)

            manejador.requestLocationUpdates(provedor,TIEMPO_MIN,DISTANCIA_MIN,this)
        }
    }

    fun mostrarMensaje(mensaje:String){
        Toast.makeText(applicationContext,mensaje,Toast.LENGTH_LONG).show()
    }

    fun verificaPermisos(){
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //DEBO PEDIR PERMISO
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
                Toast.makeText(applicationContext,"Permiso necesario para capturar rutas", Toast.LENGTH_LONG).show()
            }

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)

        }
        else{
            permisosGps = true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            100 -> {
                for((indice,valor) in grantResults.withIndex()){
                    if(valor == PackageManager.PERMISSION_GRANTED){
                        permisosGps = true
                    }else{
                        permisosGps = false
                        Log.d("Mensaje","Permiso ${permissions[indice]} denegado")
                    }
                }
            }
            else -> {
                permisosGps = false
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(19.3015059,-99.1797713)
        marcadorActual = mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,ZOOM_DEFAUTL))
        mMap.uiSettings.isZoomControlsEnabled = true
    }


    private fun actualizarMarcadoreActual(ubicacion:LatLng) {
        marcadorActualOptions = MarkerOptions().position(ubicacion).title("Actual")
        marcadorActualOptions.position(ubicacion)
        marcadorActual.remove()

        marcadorActual = mMap.addMarker(marcadorActualOptions)
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,ZOOM_DEFAUTL))
    }

    //METODOS DE LA INTERFAZ LOCATION LISTENER
    override fun onLocationChanged(location: Location?) {
        if(location != null){
            var ubicacion = LatLng(location.latitude,location.longitude)
            actualizarMarcadoreActual(ubicacion)
            mostrarMensaje("$ubicacion")

        }
    }
    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
    override fun onProviderEnabled(provider: String?) {}
    override fun onProviderDisabled(provider: String?) {}
}
