package com.example.catalogopintura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
lateinit var service: ApliService
class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista2)
        val buscar = findViewById<Button>(R.id.BtoBuscar)
        val cerrar = findViewById<Button>(R.id.Btocerrar)
        val cliImagen=findViewById<ImageView>(R.id.ImVPintura)
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service=retrofit.create(ApliService::class.java)
        cliImagen.setOnClickListener{
            cambiar()
        }

        cerrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buscar.setOnClickListener {
            getfoto()
        }
        getData()

    }
    fun getfoto(){
        val buscardor=findViewById<EditText>(R.id.EdtBuscar)
        val titulo = findViewById<TextView>(R.id.TxvTitulo)
        val imagen : ImageView = findViewById (R.id.ImVPintura)
        var posts:Posts?=null

        service.getPostByid(buscardor.text.toString().toInt()).enqueue((object :Callback<Posts>{

            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                posts=response.body()

                //.text=posts?.id.toString()
                Picasso.get()
                    .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxe8xujxeDqBwumIYPrfkSzm9k31o3O-TWKVtWyi_zEMCoIoycmvMgGnU6rxRt6QmWzIU&usqp=CAU")
                    .into(imagen)
                titulo.text=posts?.thumbnailUrl
                titulo.text=posts?.id.toString()
                Log.i("",Gson().toJson(posts))
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                t.printStackTrace()
            }

        }))
    }
    fun getData(){
        val cred2 : Credencial?=intent.getParcelableExtra("usuario1")

        val txtnombre:TextView=findViewById(R.id.TxvNombre)
        txtnombre.text=cred2!!.nombreCredencial
    }
    fun cambiar(){
        val imagen : ImageView = findViewById (R.id.ImVPintura)
        val cred4=Credencial(3,"","",imagen.toString())
        val intent = Intent(this, VistaGlobalActivity::class.java)
        intent.putExtra("imagen1", cred4)
        startActivity(intent)
    }


}