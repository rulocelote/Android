package com.example.mvprecyclerview.model.user

import android.util.Log
import com.example.mvprecyclerview.model.LoginModel
import com.example.mvprecyclerview.model.api.ApiWeb
import com.example.mvprecyclerview.model.data.Datos
import com.example.mvprecyclerview.presenter.user.UserPresent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserModelImp(var view:UserPresent):UserModel {

    override fun recuperaDatos() {
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
                Log.d("USER",t.toString())
            }

            override fun onResponse(call: Call<List<Datos>>, response: Response<List<Datos>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        val listaUsers:List<Datos> = it
                        view.MostrarUsuarios(listaUsers)
                    }?: run {
                        view.NoUser("No se encontraron resultados")
                    }
                }else{
                    view.NoUser("No se encontraron usuarios")
                }
            }

        })
    }
}
