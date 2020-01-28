package com.example.proyectoexamen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoexamen.R
import kotlinx.android.synthetic.main.adapter_noticias.view.*


class NoticiasAdapter(var listaCuadros: ArrayList<Cuadros>):RecyclerView.Adapter<NoticiasAdapter.miViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.adapter_noticias,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaCuadros.size
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        var item = listaCuadros[position]
        holder.enlazar(item)
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun enlazar(cuadros: Cuadros){
            itemView.idNombre.text = cuadros.nombre
            itemView.idDescripcion.text = cuadros.frases
            itemView.idImagen.setImageResource(cuadros.imagen)
            itemView.idFoto.setImageResource(cuadros.foto)
        }
    }

}