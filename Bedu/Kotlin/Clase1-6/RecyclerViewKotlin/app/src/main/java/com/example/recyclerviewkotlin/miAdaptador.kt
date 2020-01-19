package com.example.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*


class miAdaptador(var listaCuadros: ArrayList<Cuadros>,val context:Context):RecyclerView.Adapter<miAdaptador.miViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaCuadros.size
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        holder.nombre.text = listaCuadros[position].nombre
        holder.descripcion.text = listaCuadros[position].descripcion
        holder.imagen.setImageResource(listaCuadros[position].imagen)
        holder.foto.setImageResource(listaCuadros[position].foto)
        holder.pad.setOnClickListener { Toast.makeText(context,holder.pad.idDescripcion.text,Toast.LENGTH_SHORT).show() }
        //val item = listaCuadros.get(position)
        //holder.enlazar(item)
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val pad = itemView.padre
        val nombre = itemView.idNombre
        val descripcion = itemView.idDescripcion
        val imagen = itemView.idImagen
        val foto = itemView.idFoto

        /*fun enlazar(cuadros: Cuadros){
            with(itemView){
                idNombre.text = cuadros.nombre
                idDescripcion.text = cuadros.descripcion
                idImagen.setImageResource(cuadros.imagen)
                idFoto.setImageResource(cuadros.foto)
            }
        }*/
    }
}