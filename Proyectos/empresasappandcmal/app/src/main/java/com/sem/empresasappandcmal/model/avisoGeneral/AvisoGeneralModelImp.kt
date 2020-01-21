package com.sem.empresasappandcmal.model.avisoGeneral

import android.content.Context
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.data.avisoGeneral.AvisoGeneralRequest
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue
import com.sem.empresasappandcmal.presenter.avisos.AvisoPresenter

class AvisoGeneralModelImp (val presenter: AvisoPresenter,private val context: Context): AvisoGeneralModel {

    private val retrofit =RetrofitUtils.getRetrofit()
    private val api = retrofit.create(Api::class.java)

    override fun getListAdvise(numEmploye: String) {
        val callRespuesta = api.listaAvisosUser(numEmploye)
        callRespuesta.onEnqueue({response ->
            if (response.isSuccessful){
                if(response.body()!=null){
                    presenter.setListAviso(response.body()!!.listaAvisosPersonales)
                }
            }
        },{ presenter.errorFromConnection(it!!.message.toString())
        })

    }

    override fun validaAvisoGeneral(idEmpleado: String, idAvisoGral: String,status: String) {

        val callRespuesta = api.avisoGeneralUser(AvisoGeneralRequest(idEmpleado,idAvisoGral,status))

        callRespuesta.onEnqueue(({ response ->
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        presenter.setInfoForAdviceRead(response.body()!!.codigoOperacion,
                            response.body()!!.descripcion)
                    } else {
                        presenter.errorFromConnection(context.getString(R.string.error_conexion))
                    }
                } else {
                    presenter.errorFromConnection(context.getString(R.string.error_conexion))
                }
            }),
            ({ presenter.errorFromConnection(context.getString(R.string.error_conexion)) })
        )
    }
}