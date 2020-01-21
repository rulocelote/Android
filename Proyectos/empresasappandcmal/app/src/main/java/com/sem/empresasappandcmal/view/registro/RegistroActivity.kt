package com.sem.empresasappandcmal.view.registro

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.presenter.registro.RegistroPresenter
import com.sem.empresasappandcmal.presenter.registro.RegistroPresenterImp
import com.sem.empresasappandcmal.utils.*
import com.sem.empresasappandcmal.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity(),RegistroView, View.OnClickListener {

    companion object{
        lateinit var path:String
    }

    private lateinit var registroPresenter:RegistroPresenter
    private lateinit var progresBar:CustomProgressDialog
    private var foto:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        registroPresenter = RegistroPresenterImp(this)

        //Comprobacion para habilitar el boton siempre y cuando los campos no esten vacios
        tiet_RegNumEmpleado.textWatcher { habilitaBoton()}
        tiet_RegNom.textWatcher { habilitaBoton()}
        tiet_RegApPaterno.textWatcher { habilitaBoton()}
        tiet_RegApMaterno.textWatcher { habilitaBoton()}
        tiet_RegTelefono.textWatcher { habilitaBoton()}
        tiet_RegCorreo.textWatcher { habilitaBoton()}
        tiet_RegFechaNac.textWatcher { habilitaBoton()}
        tiet_RegPass.textWatcher { habilitaBoton() }
        tiet_RegConfirmPass.textWatcher { habilitaBoton()}

        tiet_RegFechaNac.setOnClickListener(this)
        btn_registrar.setOnClickListener(this)
        imageViewRegistro.setOnClickListener(this)

        tiet_RegFechaNac.inputType = InputType.TYPE_NULL
    }

    //Funcion llamada al obtener una respuesta exitosa al registrar al usuario
    override fun onRegistroSucces(descripcion: String) {
        this.alertDialog(getString(
            R.string.title_alert_registro_success),descripcion,
            getString(R.string.btn_aceptar),null,
            {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            })
    }

    //Funcion llamada cuando hubo un error al registrar al usuario, por id existente
    override fun onFailIdExist(descripcion:String) {
        this.alertDialog(getString(R.string.title_alert_registro_fail),descripcion,getString(R.string.btn_aceptar))
    }

    //Funcion llamada cuando hubo error al registrar al usuario por problemas de conexion con el api
    override fun onFailConexionError(descripcion:String) {
        this.alertDialog(getString(R.string.title_alert_registro_fail),descripcion,getString(R.string.btn_aceptar))
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.imageViewRegistro ->{
                if (registroPresenter.permisos(applicationContext))
                    registroPresenter.dispatchTakePictureIntent()
            }
            R.id.tiet_RegFechaNac -> showDataPickerDialog()
            R.id.btn_registrar -> enviaDatos()
        }
    }

    override fun enviaDatos() {
        this.alertDialog(
            getString(R.string.confirmacion),getString(R.string.message_alert_registro_send_data),
            getString(R.string.btn_aceptar),getString(R.string.btn_cancelar),
            {
                //Comprobacion de que los campos de correo y contraseña tengan el formato adecuado
                if(tilTelefonoRegistro.validaLong(tiet_RegTelefono,10) && tilNumEmpRegistro.validaLong(tiet_RegNumEmpleado,6) && tilCorreo.validaCorreo(tiet_RegCorreo) && tilPassRegistro.validaPassword(tiet_RegPass) && tilPassRegistroConfirmar.validaPassword(tiet_RegConfirmPass) && tilPassRegistroConfirmar.matchPassword(tiet_RegPass,tiet_RegConfirmPass)){
                        registroPresenter.enviarDatos(tiet_RegNumEmpleado.text.toString(), tiet_RegNom.text.toString(), tiet_RegApPaterno.text.toString(), tiet_RegApMaterno.text.toString(), tiet_RegFechaNac.text.toString(), tiet_RegTelefono.text.toString(), tiet_RegCorreo.text.toString(), tiet_RegPass.text.toString(), foto)
                }else{
                    tiet_RegTelefono.textWatcher { tilTelefonoRegistro.validaLong(tiet_RegTelefono,10) }
                    tiet_RegNumEmpleado.textWatcher { tilNumEmpRegistro.validaLong(tiet_RegNumEmpleado, 6) }
                    tiet_RegCorreo.textWatcher { tilCorreo.validaCorreo(tiet_RegCorreo) }
                    tiet_RegPass.textWatcher { tilPassRegistro.validaPassword(tiet_RegPass)}
                    tiet_RegConfirmPass.textWatcher { tilPassRegistroConfirmar.validaPassword(tiet_RegPass)}
                    tiet_RegConfirmPass.textWatcher { tilPassRegistroConfirmar.matchPassword(tiet_RegPass,tiet_RegConfirmPass)}
                }
            })
    }

    override fun showProgres() {
        progresBar = CustomProgressDialog(this)
        progresBar.showCustomProgressDialog()
    }

    override fun hideProgres() {
        progresBar.dismissCustomProgressDialog()
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            foto = registroPresenter.encoderPicture(path)
            imageViewRegistro.setPic(path)
        }
    }

    //Funcion encargada de validar que los campos no esten vacios y que cumplan con cierta longitud
    //para poder habilitar el boton
    fun habilitaBoton() {
        val validacion:Boolean = tiet_RegNumEmpleado.validaVacios() && tiet_RegNom.validaVacios() && tiet_RegApPaterno.validaVacios() && tiet_RegFechaNac.validaVacios() && tiet_RegTelefono.validaVacios() && tiet_RegCorreo.validaVacios() && tiet_RegPass.validaVacios() && tiet_RegConfirmPass.validaVacios()

        btn_registrar.isEnabled = validacion
        if(validacion)
            btn_registrar.setBackgroundColor(getColor(R.color.colorPrimary))
        else
            btn_registrar.setBackgroundColor(getColor(R.color.colorGris))
    }

    //Funcion encargada de mostrar el calendario y pintar la fecha seleccionada
    fun showDataPickerDialog(){
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener(){ _, year, month, day ->
            val dayStr = if(day<= 9) "0$day" else day.toString()
            val monthStr = if(month<= 9) "0${(month +1)}" else (month +1).toString()
            val selectDate = "$dayStr/$monthStr/$year"

            tiet_RegFechaNac.setText(selectDate)
        })
        newFragment.show(supportFragmentManager,"datePicker")
    }
}
