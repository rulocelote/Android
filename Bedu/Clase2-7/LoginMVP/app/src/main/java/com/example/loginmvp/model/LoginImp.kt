package com.example.loginmvp.model

class LoginImp:Login {
    val usuario:String = "Admin"
    val password:String = "123456"

    override fun Login(usuario: String, password: String): Boolean {
        return usuario.equals(this.usuario) && password.equals(this.password)
    }
}