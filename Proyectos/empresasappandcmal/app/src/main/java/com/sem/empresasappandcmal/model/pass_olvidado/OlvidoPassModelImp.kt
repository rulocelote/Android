package com.sem.empresasappandcmal.model.pass_olvidado

import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.data.pass_olvidado.OlvidoPassRequest
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue
import com.sem.empresasappandcmal.presenter.pass_olvidado.OlvidoPassPresenter

class OlvidoPassModelImp(private val olvidoPassPresenter:OlvidoPassPresenter):OlvidoPassModel{

    private val api = RetrofitUtils.getRetrofit().create(Api::class.java)

    override fun cambiarPassword(numEmpleado: String, correo: String, password: String) {
        val callResponseAsistecia = api.olvidoPass(OlvidoPassRequest(numEmpleado,correo,password))
        callResponseAsistecia.onEnqueue(
            ({
                if(it.isSuccessful){
                    it.body()?.let {
                        olvidoPassPresenter.requestSuccess(it.codigo,it.descripcion)
                    }
                }else{
                    olvidoPassPresenter.requestFail()
                }
            }),
            ({
                olvidoPassPresenter.requestFail()
            })
        )
    }

}