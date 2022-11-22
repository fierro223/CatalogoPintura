package com.example.catalogopintura

import android.app.AlertDialog
import android.content.Intent
import android.location.provider.ProviderProperties
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.ProviderStatus
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.catalogopintura.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Provider
import javax.security.auth.callback.PasswordCallback
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val iniciar = findViewById<Button>(R.id.BtoIngresar)
        val registro = findViewById<Button>(R.id.BtoRegistrarse)
        iniciar.setOnClickListener {
            setData()
        }
        registro.setOnClickListener {
           regData()
        }
        //val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }
    fun setData(){
        val cred3 : Credencial?=intent.getParcelableExtra("usuario2")
        val usuario = findViewById<EditText>(R.id.EdtUsuario)
        val contrsenia = findViewById<EditText>(R.id.EdtContrasenia)
        val usuarioC=usuario.text.toString()
        val contraseniaC=contrsenia.text.toString()
        var usuarioE=usuarioC
        var contraseniaE=contraseniaC

        if (cred3 != null) {
            usuarioE= cred3.nombreCredencial
        }
        if (cred3 != null) {
            contraseniaE = cred3.contrseniacredencial
        }

        val cred1=Credencial(1,usuarioC,contraseniaC,"")

        if(usuarioC.isEmpty() || contraseniaC.isEmpty()){
            Toast.makeText(this,"Por favor complete los campos requeridos.", Toast.LENGTH_SHORT).show()
        }else{
            if (usuarioC!=usuarioE || contraseniaC!=contraseniaE && usuarioC!="Admin" || contraseniaC!="123"){
                Toast.makeText(this,"Usuario o Contraseña incorecto.", Toast.LENGTH_SHORT).show()
            }else{

                val intent = Intent(this, InicioActivity::class.java)
                intent.putExtra("usuario1", cred1)
                startActivity(intent)
                }

            }

    }

    fun regData(){
        val intent=Intent(this,RegistroActivity::class.java)
        //intent.putExtra("usuario1",2)
        startActivity(intent)
    }


}