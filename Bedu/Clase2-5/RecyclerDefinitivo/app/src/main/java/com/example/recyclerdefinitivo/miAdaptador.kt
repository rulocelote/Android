package com.example.recyclerdefinitivo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class miAdaptador(var lista:ArrayList<Fruta>): RecyclerView.Adapter<miAdaptador.miViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        var item = lista.get(position)
        holder.enlazar(item)
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun enlazar(fruta:Fruta){
            itemView.txtNombre.text = fruta.nombre
            itemView.txtColor.text = fruta.sabor
            itemView.txtSabor.text = fruta.color
            itemView.txtTamanio.text = fruta.tamanio
            itemView.txtNombre.setOnClickListener{
                Toast.makeText(itemView.context,"soy una ${fruta.nombre}",Toast.LENGTH_LONG).show()
            }
        }
    }
}