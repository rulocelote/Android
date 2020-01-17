package com.example.registromvp.model.usuarios

import com.example.registromvp.model.api.ApiWeb
import com.example.registromvp.model.data.Datos
import com.example.registromvp.presenter.usuarios.ClientesPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsuarioModelImp(var view:ClientesPresenter):
    UsuarioModel {

    override fun recuperaDatos(){
        val URL_BASE = "http://engsigner.com/"
        var retrofitComments = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var apiWeb = retrofitComments.create(ApiWeb::class.java)
        var callRespuesta = apiWeb.datosBanco()
        callRespuesta.enqueue(object : Callback<List<Datos>>{
            override fun onFailure(call: Call<List<Datos>>, t: Throwable) {
                view.NoUser("No se pudo consumir la api")
            }
            override fun onResponse(call: Call<List<Datos>>, response: Response<List<Datos>>) {
                if(response.isSuccessful){
                    response.body()?.let{
                        val listaUsuarios:List<Datos> = it
                        view.MostrarUsuarios(response.body()!!)
                    }?:run{
                        view.NoUser("No se encontraron resultados")
                    }
                }else{
                    view.NoUser("No se encontraron usuarios")
                }
            }
        })
    }
}
