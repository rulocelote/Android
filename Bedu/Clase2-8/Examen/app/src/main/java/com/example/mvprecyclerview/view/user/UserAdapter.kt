package com.example.mvprecyclerview.view.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvprecyclerview.R
import com.example.mvprecyclerview.model.data.Datos
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(var listUser:List<Datos>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.enlazar(listUser[position])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun enlazar(datos:Datos){
            itemView.txtNombre.text = "Nombre: ${datos.nombre}"
            itemView.txtCorreo.text = "Correo: ${datos.correo}"
            itemView.txtTelefono.text = "Telefono: ${datos.telefono}"
            itemView.imgPersona.setImageResource(R.drawable.hombre)
        }
    }
}