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

        val imagenGrande: ImageView =findViewById(R.id.ImvGrande)

        val imagen1 :String?=intent.getStringExtra("imagen1")
        Picasso.get()
            .load(imagen1)
            .into(imagenGrande)

    }

}