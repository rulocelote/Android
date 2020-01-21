package com.sem.empresasappandcmal.view.pass_olvidado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.presenter.pass_olvidado.OlvidoPassPresenter
import com.sem.empresasappandcmal.presenter.pass_olvidado.OlvidoPassPresenterImp
import com.sem.empresasappandcmal.utils.*
import com.sem.empresasappandcmal.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_olvido_pass.*

class OlvidoPassActivity : AppCompatActivity(),OlvidoPassView,View.OnClickListener {

    private val presenterOlvidoPass: OlvidoPassPresenter = OlvidoPassPresenterImp(this)
    private lateinit var progresBar:CustomProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvido_pass)

        etNumEmpleadoRC.textWatcher { habilitarBoton() }
        etCorreoRC.textWatcher { habilitarBoton() }
        etPassRC.textWatcher { habilitarBoton() }
        etPassConfirmarRC.textWatcher { habilitarBoton() }

        btnCambiarRC.setOnClickListener(this)
    }

    override fun enviarDatos(){
        this.alertDialog(
            getString(R.string.confirmacion),getString(R.string.message_alert_registro_send_data),
            getString(R.string.btn_aceptar),getString(R.string.btn_cancelar),
            { presenterOlvidoPass.enviarDatos(etNumEmpleadoRC.text.toString(),etCorreoRC.text.toString(),etPassRC.text.toString()) })
    }

    override fun requestSuccess(descripcion: String){
        this.alertDialog(
            getString(R.string.title_alert_cambio_pass),
            descripcion,
            getString(R.string.btn_aceptar),null,
            {
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
        )
    }

    override fun requestFail(descripcion: String){
        this.alertDialog(getString(R.string.title_alert_error_cambiar_contrasena),descripcion,getString(R.string.btn_aceptar))
    }

    override fun errorConexion() {
        this.alertDialog(getString(R.string.title_alert_conexion_fail),getString(R.string.error_conexion),getString(R.string.btn_aceptar))
    }

    override fun showProgres() {
        progresBar = CustomProgressDialog(this)
        progresBar.showCustomProgressDialog()
    }

    override fun hideProgres() {
        progresBar.dismissCustomProgressDialog()
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnCambiarRC -> {
                if(tilNumEmpRC.validaLong(etNumEmpleadoRC,6) && tilCorreoRC.validaCorreo(etCorreoRC) && tilPassRC.validaPassword(etPassRC) && tilPassConfirmarRC.validaPassword(etPassConfirmarRC) && tilPassConfirmarRC.matchPassword(etPassRC,etPassConfirmarRC))
                    enviarDatos()
                else{
                    etNumEmpleadoRC.textWatcher { tilNumEmpRC.validaLong(etNumEmpleadoRC,6) }
                    etCorreoRC.textWatcher { tilCorreoRC.validaCorreo(etCorreoRC) }
                    etPassRC.textWatcher { tilPassRC.validaPassword(etPassRC) }
                    etPassConfirmarRC.textWatcher { tilPassConfirmarRC.validaPassword(etPassConfirmarRC) }
                    etPassConfirmarRC.textWatcher { tilPassConfirmarRC.matchPassword(etPassRC,etPassConfirmarRC) }
                }
            }

        }
    }

    fun habilitarBoton(){
        val validacion = etNumEmpleadoRC.validaVacios() && etCorreoRC.validaVacios() && etPassRC.validaVacios() && etPassConfirmarRC.validaVacios()

        btnCambiarRC.isEnabled = validacion
        if(validacion)
            btnCambiarRC.setBackgroundColor(getColor(R.color.colorPrimary))
        else
            btnCambiarRC.setBackgroundColor(getColor(R.color.colorGris))
    }
}
