package com.example.retrowiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val URL_BASE = "https://es.wikipedia.org/w/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofitComments = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var apiWeb = retrofitComments.create(ApiWeb::class.java)
        var callRespuesta = apiWeb.recuperaDatos()
        callRespuesta.enqueue(object : Callback<Query> {
            override fun onFailure(call: Call<Query>, t: Throwable) {
                Toast.makeText(applicationContext, "Ocurrio un error al consultar", Toast.LENGTH_LONG).show()
                Log.d("PROBLEMA","OCURRIO UN PROBLEMA")
            }

            override fun onResponse(call: Call<Query>, response: Response<Query>) {
                if (response.isSuccessful) {
                    //for (dato in response.body()!!) {
                        var dato = response.body()!!
                        //Log.i("TEST", dato.query.pages.tipoPage.title)
                    Log.i("TEST", "" + dato)

                    //}
                }
            }
        })
    }
}
