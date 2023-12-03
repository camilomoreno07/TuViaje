package com.example.tuviaje2.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Informe(
    var nombreArchivo: String,
    var planilla1: String,
    var planilla2: String,
    var planilla3: String,
    var planilla4: String,
    var gastoCombustible: String,
    var muchileo: String,
    var gastosAdicionales: String,
    var porcentajeConductor: String,
    var numeroPeajes: String,
    var valorPeaje: String,
    val fechaCreacion: String
) {
    constructor(
        nombreArchivo: String,
        planilla1: String,
        planilla2: String,
        planilla3: String,
        planilla4: String,
        gastoCombustible: String,
        muchileo: String,
        gastosAdicionales: String,
        porcentajeConductor: String,
        numeroPeajes: String,
        valorPeaje: String
    ) : this(
        nombreArchivo,
        planilla1,
        planilla2,
        planilla3,
        planilla4,
        gastoCombustible,
        muchileo,
        gastosAdicionales,
        porcentajeConductor,
        numeroPeajes,
        valorPeaje,
        getCurrentDate()
    )

    companion object {
        private fun getCurrentDate(): String {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val date = Date()
            return dateFormat.format(date)
        }

        fun fromString(stringRepresentation: String): Informe {
            val parts = stringRepresentation.split(",")
            return Informe(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7],
                parts[8],
                parts[9],
                parts[10]
            )
        }
    }

    override fun toString(): String {
        return "$nombreArchivo,$planilla1,$planilla2,$planilla3,$planilla4,$gastoCombustible,$muchileo,$porcentajeConductor, $numeroPeajes, $valorPeaje, $fechaCreacion"
    }
}
