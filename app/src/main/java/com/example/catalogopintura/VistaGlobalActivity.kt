package com.example.catalogopintura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VistaGlobalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_global)
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service=retrofit.create(ApliService::class.java)
        val imagenGrande: ImageView =findViewById(R.id.ImvGrande)
        val imagen1 : Credencial?=intent.getParcelableExtra("imagen1")
        var imagent=imagenGrande.toString()
        imagenGrande.setOnClickListener{
            volver()
        }


    }
    fun volver(){
        val intent = Intent(this,InicioActivity::class.java)
        startActivity(intent)
    }



}