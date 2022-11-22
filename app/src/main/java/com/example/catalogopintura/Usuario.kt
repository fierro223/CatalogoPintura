package com.example.catalogopintura

class Usuario() :Persona(nombre="", apellido="") {
    var nombreUsuario: String=""
    var contrsenia: String=""
    var email: String=""

constructor(nombreUsuario: String,contrsenia: String,email: String,nombre:String,apellido:String):this(){
    this.nombreUsuario=nombreUsuario
    this.contrsenia=contrsenia
    this.email=email
    this.nombre=nombre
    this.apellido=apellido
}

}