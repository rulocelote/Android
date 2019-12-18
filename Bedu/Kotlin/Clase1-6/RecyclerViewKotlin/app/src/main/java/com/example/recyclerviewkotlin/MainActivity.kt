package com.example.recyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista = ArrayList<Cuadros>()
    var nombre = arrayOf("Carlos", "Adalberto", "Oscar", "Cesar", "Andrea", "Guadalupe", "Patricia", "Carmen", "Alberto")
    var imagenes = arrayOf(R.drawable.cuadro1, R.drawable.cuadro2, R.drawable.cuadro3, R.drawable.cuadro4, R.drawable.cuadro5, R.drawable.cuadro6, R.drawable.cuadro7, R.drawable.cuadro8, R.drawable.cuadro9)
    var fotos = arrayOf(R.drawable.per1,R.drawable.per2,R.drawable.per3,R.drawable.per4,R.drawable.per5,R.drawable.per6,R.drawable.per7,R.drawable.per8,R.drawable.per9)
    var frases = arrayOf("Es tan corto el amor y es tan largo el olvido.\n" + "\n" + "— Pablo Neruda",
        "El que tiene imaginación, con qué facilidad saca de la nada un mundo.\n \n -Gustavo Adolfo Bécquer.",
        "No basta con saber, se debe también aplicar. No es suficiente querer, se debe también hacer. \n\n -Goethe.",
        "Puede que lo que hacemos no traiga siempre la felicidad, pero si no hacemos nada, no habrá felicidad.\n\n-Albert Camus.",
        "Acá hay tres clases de gente: las que se matan trabajando, las que deberían trabajar y las que tendrían que matarse.\n\n -Mario Benedetti.",
        "Todo fracaso es el condimento que da sabor al éxito.\n\n-Truman Capote",
        "Acepta los riesgos, toda la vida no es sino una oportunidad. El hombre que llega más lejos es, generalmente, el que quiere y se atreve a serlo.\n\n-Dale Carnegie.",
        "Daría todo lo que sé, por la mitad de lo que ignoro.\n\n-René Descartes",
        "Si crees totalmente en ti mismo, no habrá nada que esté fuera de tus posibilidades.\n\n-Wayne W. Dyer.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..nombre.size-1)
            lista.add(Cuadros(imagenes[i],fotos[i],nombre[i],frases[i]))

        var miManager = LinearLayoutManager(this)
        myRecycler.layoutManager = miManager
        myRecycler.adapter = miAdaptador(lista)
    }

}
