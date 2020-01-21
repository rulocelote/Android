package com.sem.empresasappandcmal.model.registroReporte

import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.data.registroReporte.RegistroReporteRequest
import com.sem.empresasappandcmal.presenter.registroReportes.RegistroReportePresenter
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue

class RegistroReporteModelImp (private val registroReportePresenter: RegistroReportePresenter):RegistroReporteModel {
    private val api = RetrofitUtils.getRetrofit().create(Api::class.java)

    override fun validaRegistroReporte(idProblema: String, descripcionProblema: String, fechaReporte: String, idEmpleado: String) {

        val callRespuesta = api.registroReporteUser(RegistroReporteRequest(idProblema,descripcionProblema,fechaReporte,idEmpleado))
        callRespuesta.onEnqueue(
            ({it->
                if (it.isSuccessful) {
                    it.body()?.let {
                        registroReportePresenter.retornaReporteRespuesta(it.codigoOperacion, it.descripcion)
                    }
                } else {
                    registroReportePresenter.onFailReporteConection()
                }
            }),
            ({ registroReportePresenter.onFailReporteConection() })
        )
    }

    override fun getListReportes(numEmpleado: String) {
        val callRespuesta = api.listaReporteUser(numEmpleado)
        callRespuesta.onEnqueue({response ->
            if (response.isSuccessful){
                if(response.body()!=null){
                    registroReportePresenter.setListReportesImp(response.body()!!.listaReportes)
                }
            }
        },{ registroReportePresenter.onFailReporteConection()})
    }

    override fun getList() {
        val callRespuesta = api.catalagoReporteUser()
        callRespuesta.onEnqueue({response ->
            if (response.isSuccessful){
                if(response.body()!=null){
                    //
                    registroReportePresenter.setListImp(response.body()!!.listaProblemas)
                }
            }
        },{ registroReportePresenter.onFailReporteConection() })
    }

}