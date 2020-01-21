package com.sem.empresasappandcmal.model.registro

import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.data.registro.RegistroRequest
import com.sem.empresasappandcmal.presenter.registro.RegistroPresenter
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue

class RegistroModelImp(private val registroPresenter:RegistroPresenter):RegistroModel {

    private val api = RetrofitUtils.getRetrofit().create(Api::class.java)

    override fun validaRegistro(idEmpleado: String, nombre: String, apPaterno: String, apMaterno: String, fechaNacimiento: String, celular: String, correo: String, contrasena: String, foto:String) {

        val callRespuesta = api.registroUser(RegistroRequest(idEmpleado,nombre,apPaterno,apMaterno,fechaNacimiento,celular,correo,contrasena,foto))
        callRespuesta.onEnqueue(
            ({it->
                if (it.isSuccessful) {
                    it.body()?.let {
                        registroPresenter.retornaRespuesta(it.codigoOperacion, it.descripcion)
                    }
                } else {
                    registroPresenter.onFailConection()
                }
            }),
            ({
                registroPresenter.onFailConection()
            })
        )
    }
}