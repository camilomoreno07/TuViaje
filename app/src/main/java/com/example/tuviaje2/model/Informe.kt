package com.example.tuviaje2.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Informe(var valorGasolina: String, var porcentajeConductor: String, val fechaCreacion: String) {
    constructor(valorGasolina: String, porcentajeConductor: String) : this(valorGasolina, porcentajeConductor, getCurrentDate())

    companion object {
        private fun getCurrentDate(): String {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val date = Date()
            return dateFormat.format(date)
        }
    }
}
