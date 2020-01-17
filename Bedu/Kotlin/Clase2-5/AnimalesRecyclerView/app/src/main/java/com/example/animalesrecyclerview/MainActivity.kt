package com.example.animalesrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llenarCategoria()
    }

    fun llenarCategoria(){
        var lista = ArrayList<datosAnimal>()
        var categorias = arrayOf("TERRESTRES","ACUATICOS","VOLADORES")
        var catergoriaImagen = arrayOf(R.drawable.terrestres,R.drawable.acuaticos,R.drawable.voladores)
        for(i in 0..categorias.size-1){
            lista.add(datosAnimal(categorias[i],catergoriaImagen[i]))
        }
        var miManager = LinearLayoutManager(this)
        miRecycler.layoutManager = miManager
        miRecycler.adapter = MiAdaptador(lista)
    }

    fun llenarAnimales(categoria:String){
        var lista = ArrayList<datosAnimal>()

        for(i in 0..animales(categoria).size)
            lista.add(datosAnimal(animales(categoria).get(i),imagenes(categoria).get(i)))
        var miManager = LinearLayoutManager(this)
        miRecycler2.layoutManager = miManager
        miRecycler2.adapter = MiAdaptador(lista)
    }

    fun animales(categoria:String):Array<String>{
        when(categoria){
            "TERRESTRES" -> return arrayOf("PERRO","GATO","LEON","TIGRE","PUERQUITO","CHANGUITO")
            "ACUATICOS" -> return arrayOf("TIBURON","DELFIN","AXOLOTl","TORTUGA","PEZ ESPADA","BALLENA")
            "VOLADORES" -> return arrayOf("AGUILA","HALCON","GORRION","PALOMA","COTORRO","QUETZAL")
            else -> return arrayOf("")
        }
    }

    fun imagenes(categoria: String):Array<Int>{
        when(categoria){
            "TERRESTRES" ->return arrayOf(R.drawable.perro,R.drawable.gato,R.drawable.leon,R.drawable.tigre,R.drawable.puerquito,R.drawable.changuito)
            "ACUATICOS" -> return arrayOf(R.drawable.tiburon,R.drawable.delfin,R.drawable.axolotl,R.drawable.tortuga,R.drawable.pezespada,R.drawable.ballena)
            "VOLADORES" -> return arrayOf(R.drawable.aguila,R.drawable.halcon,R.drawable.gorrion,R.drawable.paloma,R.drawable.cotorro,R.drawable.quetzal)
            else -> return arrayOf(0)
        }
    }
}
