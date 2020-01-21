package com.sem.empresasappandcmal.view.avisos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.MainActivity.Companion.numEmpleado
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.adapter.NotificacionAdapter
import com.sem.empresasappandcmal.data.notificaciones.ListaAvisos
import com.sem.empresasappandcmal.presenter.avisos.AvisoPresenter
import com.sem.empresasappandcmal.presenter.avisos.AvisoPresenterImp
import com.sem.empresasappandcmal.utils.alertDialog
import kotlinx.android.synthetic.main.fragment_notificacion.*
import kotlin.collections.ArrayList


class NotificacionFragment : Fragment(), NotificacionesAyudaView{

    companion object {
        val tag = this::class.java.simpleName
    }

    private lateinit var presenter : AvisoPresenter
    private lateinit var adaptador : NotificacionAdapter
    private lateinit var customProgressDialog : CustomProgressDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_notificacion, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AvisoPresenterImp(this, context!!)
        presenter.getListAvisos(numEmpleado)
    }

    override fun setListToAdapter(listaAvisosPersonales: ArrayList<ListaAvisos>) {
        adaptador = NotificacionAdapter(listaAvisosPersonales, context!!,this)
        list_recycler_view.layoutManager = LinearLayoutManager(activity!!)
        list_recycler_view.adapter = adaptador
    }

    override fun onFailAvisoConexionError(descripcion: String) {
        context!!.alertDialog(getString(R.string.title_alert_conexion_fail),
            getString(R.string.error_conexion),getString(R.string.btn_aceptar))
    }

    override fun showProgress() {
        customProgressDialog = CustomProgressDialog(context!!)
        customProgressDialog.showCustomProgressDialog()
    }

    override fun hideProgress() {
        customProgressDialog.dismissCustomProgressDialog()
    }
}