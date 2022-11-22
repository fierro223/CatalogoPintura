package com.example.catalogopintura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro2)
        val regresar = findViewById<Button>(R.id.BtoAgregar)
        regresar.setOnClickListener {
            regDato()

        }
    }

    fun regDato() {
        val nombre = findViewById<EditText>(R.id.EdtNombre)
        val apellido = findViewById<EditText>(R.id.EdtApellido)
        val email = findViewById<EditText>(R.id.EdtMail)
        val usuar = findViewById<EditText>(R.id.EdtAgregarUsua)
        val contra = findViewById<EditText>(R.id.EdtAgregarCon)
        val nombreC = nombre.text.toString()
        val apellidoC = apellido.text.toString()
        val emalC = email.text.toString()
        val usuarC = usuar.text.toString()
        val contraC = contra.text.toString()


        val usuaA = Usuario(usuarC, contraC, emalC, nombreC, apellidoC)
        val listaUsuario = listOf(usuaA).toString()
        val cred3 = Credencial(2, usuarC, contraC,"")
        if (nombreC.isEmpty() || apellidoC.isEmpty() || emalC.isEmpty() || usuarC.isEmpty() || contraC.isEmpty()) {
            Toast.makeText(this, "Por favor complete los campos requeridos.", Toast.LENGTH_SHORT)
                .show()

        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario2", cred3)
            startActivity(intent)
        }
    }
}



