package com.example.animalesrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_categoria.view.*

class MiAdaptador(var lista: ArrayList<datosAnimal>):RecyclerView.Adapter<MiAdaptador.miViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiAdaptador.miViewHolder{
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MiAdaptador.miViewHolder, position: Int) {
        var item = lista.get(position)
        holder.enlazar(item)
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun enlazar(datos:datosAnimal){
            itemView.txtNombre.text = datos.nombre
            itemView.imagen.setImageResource(datos.imagen)
            itemView.imagen.setOnClickListener{
                Toast.makeText(itemView.context,"${datos.nombre}, ${datos.imagen}",Toast.LENGTH_LONG).show()
                val main = MainActivity()
                main.llenarAnimales(datos.nombre)
            }
        }
    }
}