package com.sem.empresasappandcmal.adapter

import android.app.AlertDialog
import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos
import com.sem.empresasappandcmal.presenter.avisos.AvisoPresenterImp
import kotlinx.android.synthetic.main.item_notificaciones.view.*
import com.sem.empresasappandcmal.view.avisos.NotificacionesAyudaView
import kotlin.collections.ArrayList

class NotificacionAdapter(private var listaAvisosPersonales: ArrayList<ListaAvisos>, private val mContext: Context, private val mView: NotificacionesAyudaView) : RecyclerView.Adapter<NotificacionesViewHolder>() {

    private lateinit var presenter: AvisoPresenterImp

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacionesViewHolder {
        return NotificacionesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notificaciones, parent,false))
    }

    override fun onBindViewHolder(holder: NotificacionesViewHolder, position: Int) {

        val elementList: ListaAvisos = listaAvisosPersonales[position]

        holder.itemView.list_title.text = elementList.tituloAviso
        holder.itemView.list_description.text = elementList.descripcionAviso

        holder.itemView.car_avisos.setOnClickListener{
            holder.itemView.imageView2.setImageResource(0)
            val mDialogView = LayoutInflater.from (mContext).inflate(R.layout.item_avisos, null)
            val mBuilder = AlertDialog.Builder(mContext).setView (mDialogView)

            val mAlertDialog = mBuilder.show ()
            val txtTitulo = mDialogView.findViewById<TextView>(R.id.list_titleAvisosGeneral)
            val txtDescripcion = mDialogView.findViewById<TextView>(R.id.list_descriptionAvisosGeneral)
            val btnCerrar = mDialogView.findViewById<Button>(R.id.btn_reporteAvisosGeneral)

            sendNotifyReadAdvice(elementList.idAvisoGral, elementList.idEmpleado)

            txtDescripcion.movementMethod = ScrollingMovementMethod()
            txtDescripcion.text = elementList.descripcionAviso
            txtTitulo.text = elementList.tituloAviso
            btnCerrar.setOnClickListener { mAlertDialog.dismiss() }

        }
        if (elementList.status == 0){
            holder.itemView.imageView2.setImageResource(R.drawable.ic_desactivado)
        } else {
            holder.itemView.imageView2.setImageResource(0)
        }
    }

    private fun sendNotifyReadAdvice(idGeneralAdvice: String, numEmpledo: String) {
        presenter = AvisoPresenterImp(mView,mContext)
        presenter.notifyReadAdvice(numEmpledo, idGeneralAdvice, "1")
    }

    override fun getItemCount(): Int = listaAvisosPersonales.size
}
    class NotificacionesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
       private val mTitleView: TextView = itemView.findViewById(R.id.list_title)
       private var mYearView: TextView = itemView.findViewById(R.id.list_description)
    }
