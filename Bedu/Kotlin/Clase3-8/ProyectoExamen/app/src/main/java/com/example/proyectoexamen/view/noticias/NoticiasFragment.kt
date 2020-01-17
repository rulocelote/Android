package com.example.proyectoexamen.view.noticias


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoexamen.R
import com.example.proyectoexamen.adapter.Cuadros
import com.example.proyectoexamen.adapter.NoticiasAdapter
import com.example.proyectoexamen.presenter.noticias.NoticiasPresenter
import com.example.proyectoexamen.presenter.noticias.NoticiasPresenterImp
import kotlinx.android.synthetic.main.fragment_noticias.*

/**
 * A simple [Fragment] subclass.
 */
class NoticiasFragment : Fragment(),NoticiasView {

    var noticiasPresenter:NoticiasPresenter = NoticiasPresenterImp(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_noticias, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noticiasPresenter.RecuperarDatos()
        Toast.makeText(context,"Entro a fragment",Toast.LENGTH_SHORT).show()
    }

    override fun MuestraDatos(listCuadros:ArrayList<Cuadros>) {
        Log.d("noticias","$listCuadros")
        recyclerNoticias.layoutManager = LinearLayoutManager(context)
        recyclerNoticias.adapter = NoticiasAdapter(listCuadros)
    }


}
