package com.sem.empresasappandcmal.view.perfil

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.MainActivity
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.data.perfil.ListaAsistencia
import com.sem.empresasappandcmal.presenter.perfil.PerfilPresenter
import com.sem.empresasappandcmal.presenter.perfil.PerfilPresenterImp
import com.sem.empresasappandcmal.utils.alertDialog
import com.sem.empresasappandcmal.utils.encoder
import com.sem.empresasappandcmal.utils.obtenerFecha
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlin.collections.ArrayList

@Suppress("UNREACHABLE_CODE")
class PerfilFragment : Fragment(),View.OnClickListener, PerfilView {

    companion object{
        val tag = this::class.java.simpleName
    }

    private lateinit var perfilPresenter: PerfilPresenter
    private lateinit var progresBar:CustomProgressDialog
    private lateinit var numEmpleado:String
    private var fechaAsistencia = arrayListOf<ListaAsistencia>()

    lateinit var path:String
    var latitud:Double = 0.0
    var longitud:Double = 0.0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate( R.layout.fragment_perfil, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        perfilPresenter = PerfilPresenterImp(this)

        perfilPresenter.enviarDatos(MainActivity.numEmpleado)
        perfilPresenter.enviarAsistencia(MainActivity.numEmpleado)

        calendarPerfil.maxDate = System.currentTimeMillis()

        btnFloatingCamera.setOnClickListener(this)
        calendarPerfil.setOnDateChangeListener {_, i, i2, i3 ->
            perfilPresenter.mostrarAsistencia(i3.toString(), (i2+1).toString(), i.toString(), fechaAsistencia)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun requestSucces(asistencia: ArrayList<ListaAsistencia>) {
        val fecha = obtenerFecha()
        asistencia.forEach {
            fechaAsistencia.add(it)
        }
        perfilPresenter.mostrarAsistencia(fecha.substring(0,2), fecha.substring(3,5), fecha.substring(6,10), fechaAsistencia)
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun requestDatos(idEmpleado: String, nombre: String, apellido: String, foto: String){
        txtNombrePerfil.text = "${nombre.toUpperCase()} ${apellido.toUpperCase()}"
        txtNumEmpPerfil.text = idEmpleado
        numEmpleado = idEmpleado

        if (foto != "")
            fotoPerfil.setImageDrawable(perfilPresenter.decoderImage(foto));
    }

    override fun requestFail(descripcion: String) {
        context!!.alertDialog(getString(R.string.title_alert_conexion_fail),
            descripcion,getString(R.string.btn_aceptar))
    }

    override fun failConexion(){
        context!!.alertDialog(getString(R.string.title_alert_conexion_fail),
            getString(R.string.error_conexion),getString(R.string.btn_aceptar))
    }

    override fun requestAsistencia(descripcion: String) {
        context!!.alertDialog(getString(R.string.title_alert_asistencia),
            descripcion,getString(R.string.btn_aceptar),
            null,
            { perfilPresenter.enviarAsistencia(numEmpleado) }
        )
    }

    @SuppressLint("SetTextI18n")
    override fun asistenciaRegistrada(fecha:String, hora:String){
        val descripcion = perfilPresenter.comparaHora(hora)

        txtFechaAsistencia.text = getString(R.string.fecha_asistencia,fecha)
        txtHoraAsistencia.text = getString(R.string.hora_asistencia,hora)
        txtMensajeHora.text = descripcion
        txtDescAsistencia.text = ""
    }

    override fun sinAsistencia(fecha:String){
        txtFechaAsistencia.text = fecha
        txtHoraAsistencia.text = getString(R.string.sin_hora_asistencia)
        txtMensajeHora.text = ""
        txtDescAsistencia.text = getString(R.string.sin_asistencia)
    }

    override fun showProgres() {
        progresBar = CustomProgressDialog(context!!)
        progresBar.showCustomProgressDialog()
    }

    override fun hideProgres() {
        progresBar.dismissCustomProgressDialog()
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnFloatingCamera -> {
                if (perfilPresenter.permisos(context!!)){
                    perfilPresenter.proveedorLocation()
                }else
                    Toast.makeText(context,getString(R.string.sin_permisos),Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Funcion encargada de realizar acciones cuando la foto se haya tomado
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == AppCompatActivity.RESULT_OK) {
            val encoder = encoder(path)
            val fecha = obtenerFecha()
            context!!.alertDialog(
                getString(R.string.title_alert_assistance),
                getString(R.string.message_alert_assistance),
                getString(R.string.btn_alert_positive_assistance),
                getString(R.string.btn_alert_neutral_assistance),
                { perfilPresenter.confirmacionEnviarAsistencia(numEmpleado, encoder, fecha, latitud, longitud) })
        }
    }
}