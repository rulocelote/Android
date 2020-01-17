package com.example.demoapichofer.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapichofer.R
import com.example.demoapichofer.modelos.Chofer
import kotlinx.android.synthetic.main.item_chofer.view.*

class ChoferesAdapter(var lista: List<Chofer>):RecyclerView.Adapter<ChoferesAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun enlazarItem(chofer: Chofer) {
            itemView.txtChofer.text = "${chofer.nombre} ${chofer.apellidos}"
            itemView.txtTelefono.text = chofer.telefono
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_chofer, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var chofer = lista.get(position)
        holder.enlazarItem(chofer)
    }
}