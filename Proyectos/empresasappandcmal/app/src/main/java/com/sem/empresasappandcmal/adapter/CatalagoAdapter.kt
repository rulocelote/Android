package com.sem.empresasappandcmal.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.data.catalagoReporte.Problema

class CatalagoAdapter (var context: Context, var listaProblemas :ArrayList<Problema>): BaseAdapter() {

    val nInflater : LayoutInflater = LayoutInflater.from(context)

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, contentView: View?, p2: ViewGroup?): View {
        val vh :CatalagoViewHolder
        val view: View = nInflater.inflate(R.layout.item_catalago, p2, false)
        vh = CatalagoViewHolder (view)
        vh.label.text = listaProblemas[position].descripcionProblema
        return view
    }

    override fun getItem(p0: Int): Problema {
        return listaProblemas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listaProblemas[p0].idProblema.toLong()
    }

    override fun getCount(): Int {
        return listaProblemas.size
    }

    private class CatalagoViewHolder (view : View?){
        val label: TextView = view?.findViewById(R.id.txtCatalagoReporte) as TextView
    }
}