package com.example.firebasebd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ValueEventListener, ChildEventListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = BaseDatos.obtenerInstanciaProductos()

        db.addChildEventListener(this)
        db.addValueEventListener(this)

        btnGuardar.setOnClickListener {
            val p = Producto(txtNombre.text.toString(), txtPrecio.text.toString().toDouble())
            db.push().setValue(p)

            txtNombre.setText("")
            txtPrecio.setText("")


            //Actualizar
            //db.child("-LxwskVesvZMOiUG-vyF").child("precio").setValue("45")
        }

        //Eliminar
        //db.child().removeValue
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        val producto = p0.getValue(Producto::class.java)

        if(producto != null){
            Log.d("mensaje","movido $producto")
        }
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        val producto = p0.getValue(Producto::class.java)

        if(producto != null){
            Log.d("mensaje","Removido $producto")
        }
    }

    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val producto = p0.getValue(Producto::class.java)

        if(producto != null){
            producto.id_firebase = p0.key.toString()

            Toast.makeText(applicationContext,producto.id_firebase,Toast.LENGTH_LONG).show()
            Log.d("mensaje","Agregando $producto")
        }
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        val producto = p0.getValue(Producto::class.java)

        if(producto != null){
            Log.d("mensaje","Removido $producto")
        }
    }

    override fun onDataChange(p0: DataSnapshot) {
        Log.d("Mensaje","hijos = ${p0.childrenCount}")
        for(snapshot in p0.children){
            var producto = snapshot.getValue(Producto::class.java)
            if(producto != null){
                Log.d("Mensaje","Agregado $producto" )
            }
        }
    }

    override fun onCancelled(p0: DatabaseError) {
    }
}
