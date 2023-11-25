package com.example.tuviaje

import android.os.Parcel
import android.os.Parcelable

data class Informe(
    val gastoGasolina: String,
    val valorGasolina: Double,
    val porcentajeConductor: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gastoGasolina)
        parcel.writeDouble(valorGasolina)
        parcel.writeDouble(porcentajeConductor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Informe> {
        override fun createFromParcel(parcel: Parcel): Informe {
            return Informe(parcel)
        }

        override fun newArray(size: Int): Array<Informe?> {
            return arrayOfNulls(size)
        }
    }
}