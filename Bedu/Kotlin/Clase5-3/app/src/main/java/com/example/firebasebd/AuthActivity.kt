package com.example.firebasebd

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_auth.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class AuthActivity : AppCompatActivity(),FirebaseAuth.AuthStateListener {

    private val PROVEEDOR_DESCONOCIDO: String = "desconocido"
    private val PASSWORD_FIREBASE = "password"
    private val PASSWORD_FACEBOOK = "facebook.com"
    private val REQUES_CODE: Int = 200
    lateinit var mFirebaseAuth:FirebaseAuth
    lateinit var mFirebaseAuthListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseAuthListener = this

        try {
            var certificados =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                    PackageManager.GET_SIGNING_CERTIFICATES//
                }
                else{
                    PackageManager.GET_SIGNATURES
                }

            val info = packageManager.getPackageInfo(
                "com.joseluisucan.demofirebase",
                certificados
            )
            var iterador = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                info.signingInfo.signingCertificateHistory
            } else {
                info.signatures
            }
            for (signature in iterador) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", android.util.Base64.encodeToString(md.digest(), android.util.Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }

    }

    override fun onAuthStateChanged(f0: FirebaseAuth) {
        var user: FirebaseUser? = f0.currentUser
        var proveedores = mutableListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build()
        )

        if(user!=null){
            var proveedor =
                if(user.providerData!= null)
                    user.providerData.get(1).providerId
                else
                    PROVEEDOR_DESCONOCIDO

            mostrarDatos(user.displayName,user.email,proveedor,user.photoUrl.toString())
        }
        else{

            limpiarDatos()
            startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setAvailableProviders(proveedores)
                .setTosAndPrivacyPolicyUrls("http://google.com","http://google.com")
                .build(),REQUES_CODE)
        }
    }

    private fun limpiarDatos() {
        mostrarDatos("","","")
    }

    private fun mostrarDatos(displayName: String?, email: String?, proveedor: String,foto:String = "") {
        txtUsuario.text = displayName.toString()
        txtEmail.text = email.toString()
        txtProveedor.text = proveedor
        when(proveedor){
            PASSWORD_FIREBASE->{
                imgProveedor.setImageResource(R.drawable.ic_email)
                imgFotoPerfil.setImageResource(R.mipmap.ic_launcher_round)
            }
            PASSWORD_FACEBOOK->{
                imgProveedor.setImageResource(R.drawable.ic_facebook)
                Glide.with(this).load(foto).into(imgFotoPerfil)
            }
            else->{
                imgFotoPerfil.setImageResource(R.mipmap.ic_launcher_round)
                imgProveedor.setImageResource(R.drawable.ic_block_helper)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUES_CODE ->{
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(applicationContext,"Bienvenido....",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(applicationContext,"Algo salio mal, intenta de nuevo",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mFirebaseAuth.addAuthStateListener(mFirebaseAuthListener)
    }
    override fun onPause() {
        super.onPause()
        if(mFirebaseAuthListener != null){
            mFirebaseAuth.removeAuthStateListener(mFirebaseAuthListener)
        }
    }

    fun cerrarSesionFirebase(view: View) {
        AuthUI.getInstance().signOut(applicationContext)
    }

}

