package com.sem.empresasappandcmal.view.reportes

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ayuda.*
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.empresasappandcmal.CustomProgressDialog
import com.sem.empresasappandcmal.MainActivity
import com.sem.empresasappandcmal.MainActivity.Companion.numEmpleado
import com.sem.empresasappandcmal.R
import com.sem.empresasappandcmal.adapter.AyudaAdapter
import com.sem.empresasappandcmal.adapter.CatalagoAdapter
import com.sem.empresasappandcmal.data.catalagoReporte.Problema
import com.sem.empresasappandcmal.data.reporte.ListaReportes
import com.sem.empresasappandcmal.presenter.registroReportes.RegistroReportePresenter
import com.sem.empresasappandcmal.presenter.registroReportes.RegistroReportePresenterImp
import com.sem.empresasappandcmal.utils.alertDialog
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AyudaFragment : Fragment(), AdapterView.OnItemSelectedListener,AyudaView {

    private lateinit var progresBar:CustomProgressDialog
    private lateinit var edit_descripcionReporte: EditText
    private lateinit var spinner_categoria: Spinner
    private lateinit var adaptador: AyudaAdapter
    private val registroReportePresenter: RegistroReportePresenter = RegistroReportePresenterImp(this)

    companion object {
        val tag = this::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )
            : View? = inflater.inflate(R.layout.fragment_ayuda, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registroReportePresenter.getListReportesImp(numEmpleado)

        floatingActionButton.setOnClickListener {
            registroReportePresenter.getListImp()
        }
    }

    override fun getListReportes(listReport: ArrayList<ListaReportes>) {
        adaptador = AyudaAdapter(listReport)
        recyclerAyuda.layoutManager = LinearLayoutManager(activity!!)
        recyclerAyuda.adapter = adaptador
    }

    override fun getList(lst: ArrayList<Problema>) {
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.item_reporte, null)
        val mBuilder = AlertDialog.Builder(context).setView(mDialogView).setTitle(getString(R.string.agregar_reporte))
        val mAlertDialog = mBuilder.show()
        val MispinnerAPintar = mDialogView.findViewById(R.id.spinner_categoria) as Spinner

        MispinnerAPintar.onItemSelectedListener = this
        MispinnerAPintar.adapter = CatalagoAdapter(activity!!, lst)
        edit_descripcionReporte = mDialogView.findViewById(R.id.edit_descripcionReporte)
        spinner_categoria = mDialogView.findViewById(R.id.spinner_categoria)

        val btnReportar = mDialogView.findViewById<Button>(R.id.btn_reporte)
        btnReportar.setOnClickListener {
            if (edit_descripcionReporte.text.isNotEmpty()) {
                enviarReporteDatos()
                mAlertDialog.dismiss()
            } else {
                activity!!.alertDialog(
                    getString(R.string.title_alert_dialog_reportes_vacios),
                    getString(R.string.mensaje_alert_reportes_vacios),
                    getString(R.string.btn_aceptar)
                )
            }

        }
    }

    override fun obtenerReporteDatos(): Array<String> {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val fecha = dateFormat.format(Date())
        val datos = arrayOf(spinner_categoria.selectedItemId.toString(), edit_descripcionReporte.text.toString(), fecha, MainActivity.numEmpleado)

        return datos
    }

    override fun enviarReporteDatos() {
        activity!!.alertDialog(
            getString(R.string.confirmacion), getString(R.string.message_alert_registro_send_data),
            getString(R.string.btn_aceptar), getString(R.string.btn_cancelar),
            {
                registroReportePresenter.enviarReporteDatos(obtenerReporteDatos())
            })
    }

    override fun onRegistroReporteSucces(descripcion: String) {
        activity!!.alertDialog(
            getString(R.string.title_alert_registro_success),
            descripcion, getString(R.string.btn_aceptar),
            null, { registroReportePresenter.getListReportesImp(numEmpleado) })
    }

    override fun onError(error: String) {
        context!!.alertDialog(getString(R.string.title_alert_conexion_fail),getString(R.string.error_conexion))
    }

    override fun onFailReporteConexionError() {
        activity!!.alertDialog(
            getString(R.string.title_alert_conexion_fail), getString(R.string.error_conexion), getString(
                R.string.btn_aceptar
            )
        )
    }

    override fun showProgres() {
        progresBar = CustomProgressDialog(context!!)
        progresBar.showCustomProgressDialog()
    }

    override fun hideProgres() {
        progresBar.dismissCustomProgressDialog()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}
}
