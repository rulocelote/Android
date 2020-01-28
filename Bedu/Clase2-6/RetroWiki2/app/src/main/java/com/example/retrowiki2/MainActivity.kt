package com.example.retrowiki2

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
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
    }

    fun enviar(view:View){
        var tag = view.tag
        btnEnviar.setOnClickListener{
            Toast.makeText(applicationContext, "TAG = $tag", Toast.LENGTH_LONG).show()
            var retrofitQuery = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            var apiWeb = retrofitQuery.create(ApiWeb::class.java)
            var callRespuesta = when(tag){
                "xbox"->apiWeb.datosXbox()
                "wii"->apiWeb.datosWii()
                "nintendo"->apiWeb.datosNintendo()

                else->apiWeb.datosXbox()
            }
            callRespuesta.enqueue(object: Callback<Querys>{
                override fun onFailure(call: Call<Querys>, t: Throwable) {
                    Toast.makeText(applicationContext, "Ocurrio un error al consultar", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Querys>, response: Response<Querys>) {
                    var dato = response.body()
                    if (dato != null) {
                        var encabezado = when(tag){
                            "xbox" -> dato.query.pages.xbox.extract
                            "wii" -> dato.query.pages.wii.extract
                            "nintendo" -> dato.query.pages.nintendo.extract
                            else -> dato.query.pages.xbox.extract
                        }
                        miWebView.loadData(encabezado,"text/html","UFT-8")
                    }
                }
            })
        }
    }
}

