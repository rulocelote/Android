package com.sem.empresasappandcmal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sem.empresasappandcmal.presenter.MainPresenter
import com.sem.empresasappandcmal.presenter.MainPresenterImp
import com.sem.empresasappandcmal.utils.alertDialog
import com.sem.empresasappandcmal.view.avisos.NotificacionFragment
import com.sem.empresasappandcmal.view.login.LoginActivity
import com.sem.empresasappandcmal.view.perfil.PerfilFragment
import com.sem.empresasappandcmal.view.reportes.AyudaFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mainPresenter: MainPresenter = MainPresenterImp(this)

    companion object {
        lateinit var numEmpleado: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationBar(bottomNavigation)
        setSupportActionBar(toolbarMain)

        if (intent.extras?.get("idEmpleado") != null)
            numEmpleado = intent.extras.get("idEmpleado").toString()
        else
            numEmpleado = ""
    }

    //Funcion para mostrar y ocultar el menu top
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit_app -> {
                this.alertDialog(
                    getString(R.string.title_alert_exit_app),
                    getString(R.string.message_alert_exit_app),
                    getString(R.string.btn_alert_positive_exit),
                    getString(R.string.btn_cancelar),
                    {cerrarSesion()}
                )
            }
        }
        return super.onContextItemSelected(item)
    }

    //Funcionalidad para los botones del Menu inferior
    private fun setupNavigationBar(navigationBar: BottomNavigationView){
        mostrarFragment(PerfilFragment(), PerfilFragment.tag)
        navigationBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_perfil -> {
                    mostrarFragment(PerfilFragment(),PerfilFragment.tag)
                    true
                }
                R.id.action_noticias -> {
                    mostrarFragment(
                        NotificacionFragment(),
                        NotificacionFragment.tag
                    )
                    true
                }
                R.id.action_ayuda -> {
                    mostrarFragment(AyudaFragment(), AyudaFragment.tag)
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if (count == 1)
            finish()
         else
            super.onBackPressed()
    }

    //Funcion que permite crear nuevos fragmentos, recibiendo como parametro el fragmento que queremos mostrar
    private fun mostrarFragment(fragment: Fragment, tag: String){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContenedorMain,fragment)
            .addToBackStack(tag)
            .commit()
    }



    private fun cerrarSesion(){
        val intent: Intent = Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            mainPresenter.deleteDatabase()
            startActivity(intent)
            finish()
    }
}
