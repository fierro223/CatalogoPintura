package com.example.catalogopintura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
lateinit var service: ApliService
class InicioActivity : AppCompatActivity() {
    var imag:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista2)
        val buscar = findViewById<Button>(R.id.BtoBuscar)
        val cerrar = findViewById<Button>(R.id.Btocerrar)
        val cliImagen=findViewById<ImageView>(R.id.ImVPintura)
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://collectionapi.metmuseum.org/")
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
        var data:Data?=null

        service.getPostByid(buscardor.text.toString().toInt()).enqueue((object:Callback<Data>{

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                data=response.body()
                if (data?.primaryImageSmall==""){
                    titulo.text="No se Encontro imagen"
                    Picasso.get()
                        .load("https://cdn.pixabay.com/photo/2016/01/20/18/35/x-1152114_1280.png")
                        .into(imagen)
                }else {

                    Picasso.get()
                        .load(data?.primaryImageSmall.toString())
                        .into(imagen)
                    imag = data?.primaryImageSmall.toString()
                    titulo.text = data?.title.toString()
                    Log.i("", Gson().toJson(data))
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
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
        val intent = Intent(this, VistaGlobalActivity::class.java)
        intent.putExtra("imagen1", imag)
        startActivity(intent)
    }


}