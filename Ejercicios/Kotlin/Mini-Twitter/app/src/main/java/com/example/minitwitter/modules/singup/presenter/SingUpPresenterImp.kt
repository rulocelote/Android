package com.example.minitwitter.modules.singup.presenter

import com.example.minitwitter.modules.singup.model.SingUpModel
import com.example.minitwitter.modules.singup.model.SingUpModelImp
import com.example.minitwitter.modules.singup.view.SingUpView

class SingUpPresenterImp(val singUpView: SingUpView):SingUpPresenter {

    val singUpModel:SingUpModel = SingUpModelImp(this)

    override fun validaDatos(userName: String, email: String, password: String) {
        if(userName.isEmpty()){
            singUpView.userEmpty()
        }else if(email.isEmpty()){
            singUpView.emailEmpty()
        }else if(password.isEmpty()){
            singUpView.passwordEmpty()
        }else{
            singUpModel.doRegistro(userName,email,password)
        }
    }

    override fun responseSucceful() {
        singUpView.responseSucceful()
    }

    override fun responseFail() {
        singUpView.responseFail()
    }

    override fun responseErrorInternet() {
        singUpView.responseErrorInternet()
    }

}