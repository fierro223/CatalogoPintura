package com.example.catalogopintura

import android.widget.EditText

abstract class Persona {
    var nombre: String=""
    var apellido: String=""

    constructor(nombre:String,apellido:String){
        this.nombre=nombre
        this.apellido=apellido
    }

}