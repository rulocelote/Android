package com.sem.empresasappandcmal.model.perfil

import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.data.asistencia.AsistenciaRequest
import com.sem.empresasappandcmal.presenter.perfil.PerfilPresenter
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue

class PerfilModelImp(private val perfilPresenter:PerfilPresenter): PerfilModel{

    private val api = RetrofitUtils.getRetrofit().create(Api::class.java)

    override fun recuperarAsistencia(numEmpleado: String){
        val callResponseAsistecia = api.perfilAsistencia(numEmpleado)
        callResponseAsistecia.onEnqueue(
            ({
                if(it.isSuccessful){
                    it.body()?.let {
                        perfilPresenter.requestAsistencia(it.codigoOperacion,it.descripcion,it.asistencia)
                    }
                }else{
                    perfilPresenter.requestFail()
                }
            }),
            ({
                perfilPresenter.requestFail()
            })
        )
    }

    override fun recuperarDatos(numEmpleado: String) {
        val callResponseUser = api.perfilUser(numEmpleado)
        callResponseUser.onEnqueue(
            ({
                if(it.isSuccessful){
                    it.body()?.let {
                        perfilPresenter.requestData(it.idEmpleado,it.nombre,it.apellido,it.foto)
                    }
                }else{
                    perfilPresenter.requestFail()
                }
            }),
            ({
                perfilPresenter.requestFail()
            })
        )
    }

    override fun registraAsistencia(idEmpleado: String, foto: String, fechaAsistencia: String, latitud: Double, longitud: Double) {
        val callRespuesta = api.registroAsistencia(AsistenciaRequest(idEmpleado,foto,fechaAsistencia,latitud,longitud))
        callRespuesta.onEnqueue(
            ({
                if(it.isSuccessful){
                    it.body()?.let {
                        perfilPresenter.asistenciaRequest(it.descripcion)
                    }
                }else{
                    perfilPresenter.requestFailAsistencia()
                }
            }),
            ({
                perfilPresenter.requestFailAsistencia()
            })
        )
    }
}