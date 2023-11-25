package com.example.tuviaje


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class InformeActivity : AppCompatActivity() {

    private lateinit var informesList: MutableList<Informe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informe)

        informesList = mutableListOf()

        val editTextText = findViewById<EditText>(R.id.editTextText)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // Obtener los datos ingresados
            val gastoGasolina = editTextText.text.toString()
            val valorGasolina = editTextNumber.text.toString().toDoubleOrNull() ?: 0.0
            val porcentajeConductor = editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0

            // Crear un objeto Informe y agregarlo a la lista
            val nuevoInforme = Informe(gastoGasolina, valorGasolina, porcentajeConductor)
            InformesSingleton.informesList.add(nuevoInforme)

            // Borrar los valores de los EditText
            editTextText.text.clear()
            editTextNumber.text.clear()
            editTextNumber2.text.clear()

        }
    }


}