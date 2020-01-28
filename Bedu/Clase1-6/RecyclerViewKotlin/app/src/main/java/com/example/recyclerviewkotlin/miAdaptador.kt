package com.example.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class miAdaptador(val lista:ArrayList<Cuadros>,val context: Context): RecyclerView.Adapter<miAdaptador.MiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        return MiViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.foto.setImageResource(lista[position].foto)
        holder.nombre.text = lista[position].nombre
        holder.imagen.setImageResource(lista[position].imagen)
        holder.descripcion.text = lista[position].descripcion
        holder.padre.setOnClickListener {
            Toast.makeText(context, lista[position].descripcion, Toast.LENGTH_SHORT).show()
        }
    }

    class MiViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val foto = itemView.idFoto
        val nombre = itemView.idNombre
        val descripcion = itemView.idDescripcion
        val imagen = itemView.idImagen
        val padre = itemView.padre
    }
}



