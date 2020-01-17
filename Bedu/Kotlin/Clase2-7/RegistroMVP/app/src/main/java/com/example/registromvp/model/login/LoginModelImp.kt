package com.example.registromvp.model.login

class LoginModelImp: LoginModel {
    val nombre = arrayOf("Carlos","Alberto","Daniel","Jose","Daniela","Andrea","Metztli","Samanta","Jaqueline","Paola")
    val telefono = arrayOf("123456","125342","1234643","24120","4363125","123456","125342","1234643","24120","4363125")
    val email = arrayOf("charlye934@gmail.com","alberto@gmail.com","daniel@gmail.com","jose@gmail.com","daniela@gmail.com","andrea@gmail.com","metztli@gmail.com","samanta@gmail.com","jaqueline@gmail.com","paola@gmail.com")
    val mapUsuarios= mutableMapOf<String,String>()

    override fun CompruebaRegistro(email: String): Boolean {
        return email in this.email
    }

    override fun RetornaDatos(email:String): String? {
        for(i in 0..9)
            mapUsuarios.put(this.email[i],this.nombre[i])
        return mapUsuarios[email]
    }


}