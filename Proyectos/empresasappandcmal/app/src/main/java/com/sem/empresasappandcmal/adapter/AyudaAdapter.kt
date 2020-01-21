package com.sem.empresasappandcmal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.data.reporte.ListaReportes
import kotlinx.android.synthetic.main.item_ayuda.view.*

class AyudaAdapter(private val listaReportes: ArrayList<ListaReportes>) : RecyclerView.Adapter<AyudaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyudaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AyudaViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = listaReportes.size

    override fun onBindViewHolder(holder: AyudaViewHolder, position: Int) {
        val ayudaModel: ListaReportes = listaReportes[position]
        holder.enlazar(ayudaModel)
    }
}

class AyudaViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_ayuda, parent, false)) {
    fun enlazar(listaReportes: ListaReportes) {
        itemView.txtFolioAyuda.text = listaReportes.idReporte
        itemView.txtFechaAyuda.text = listaReportes.fechaReporte
        itemView.txt_descripcionAyuda.text = listaReportes.descripcionProblema
    }
}