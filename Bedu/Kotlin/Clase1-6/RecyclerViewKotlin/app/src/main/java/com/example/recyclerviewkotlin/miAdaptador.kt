package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*


class miAdaptador(var listaCuadros: ArrayList<Cuadros>):RecyclerView.Adapter<miAdaptador.miViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaCuadros.size
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        var item = listaCuadros.get(position)
        holder.enlazar(item)
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun enlazar(cuadros: Cuadros){
            itemView.idNombre.text = cuadros.nombre
            itemView.idDescripcion.text = cuadros.descripcion
            itemView.idImagen.setImageResource(cuadros.imagen)
            itemView.idFoto.setImageResource(cuadros.foto)
        }
    }

}