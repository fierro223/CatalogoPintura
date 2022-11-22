package com.example.catalogopintura

import android.os.Parcel
import android.os.Parcelable

data class Credencial(var idCredencial:Int, var nombreCredencial:String, var contrseniacredencial:String,var imagenCreden:String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idCredencial)
        parcel.writeString(nombreCredencial)
        parcel.writeString(contrseniacredencial)
        parcel.writeString(imagenCreden)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Credencial> {
        override fun createFromParcel(parcel: Parcel): Credencial {
            return Credencial(parcel)
        }

        override fun newArray(size: Int): Array<Credencial?> {
            return arrayOfNulls(size)
        }
    }

}
