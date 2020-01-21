package com.sem.empresasappandcmal.model.login

import com.sem.empresasappandcmal.api.Api
import com.sem.empresasappandcmal.presenter.login.LoginPresenter
import com.sem.empresasappandcmal.data.login.LoginRequest
import com.sem.empresasappandcmal.model.RetrofitUtils
import com.sem.empresasappandcmal.model.onEnqueue

class LoginModelImp(private val loginPresenter: LoginPresenter): LoginModel {

    private val api = RetrofitUtils.getRetrofit().create(Api::class.java)

    override fun validaLogin(numEmpleado: String, password: String) {
        val callRespuesta = api.loginUser(LoginRequest(numEmpleado, password))
        callRespuesta.onEnqueue(
            ({
                if(it.isSuccessful){
                    it.body()?.let {
                        loginPresenter.retornaRespuesta(it.codigoOperacion,it.descripcion,it.idEmpleado)
                    }
                }else{
                    loginPresenter.conexionFail()
                }
            }),
            ({
                loginPresenter.conexionFail()
            })
        )
    }
}

