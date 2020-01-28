package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val URL_BASE = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //miWebView.webViewClient = WebViewClient()
        //miWebView.loadUrl("http://www.google.com")

        //var encabezado = "<h1>Carlos Arteaga</h1>"
        //miWebView.loadData(encabezado,"text/html","UTF-8")
        var retrofitComments = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var apiWeb = retrofitComments.create(ApiWeb::class.java)
        var callRespuesta = apiWeb.recuperaComentarios("comments")
        callRespuesta.enqueue(object :Callback<List<Comentario>>{
            override fun onFailure(call: Call<List<Comentario>>, t: Throwable) {
                Log.e("TEST",t.toString())
                Toast.makeText(applicationContext,"Ocurrio un error al consultar",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<Comentario>>,
                response: Response<List<Comentario>>
            ) {
                if(response.isSuccessful){
                    for(comentario in response.body()!!){
                       Log.i("TEST",comentario.name)
                        Log.i("TEST",comentario.email)
                        Log.i("TEST",comentario.body)
                    }
                }
            }

        })
    }
}

