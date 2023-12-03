package com.example.tuviaje2.controller

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje2.R
import com.example.tuviaje2.model.Informe
import com.example.tuviaje2.adapter.InformeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class InformeActivity : AppCompatActivity() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var informeList: ArrayList<Informe>
    private lateinit var informeAdapter: InformeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informe_activity)

        informeList = loadInformeListFromSharedPreferences()
        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        /**set Adapter*/
        informeAdapter = InformeAdapter(this, informeList){ saveInformeListToSharedPreferences()}
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = informeAdapter
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.add_item, null)
        val nombreArchivo = view.findViewById<EditText>(R.id.nombreArchivo)
        val planilla1 = view.findViewById<EditText>(R.id.planilla1)
        val planilla2 = view.findViewById<EditText>(R.id.planilla2)
        val planilla3 = view.findViewById<EditText>(R.id.planilla3)
        val planilla4 = view.findViewById<EditText>(R.id.planilla4)
        val gastoCombustible = view.findViewById<EditText>(R.id.gastoCombustible)
        val muchileo = view.findViewById<EditText>(R.id.muchileo)
        val gastosAdicionales = view.findViewById<EditText>(R.id.gastosAdicionales)
        val porcentajeConductor = view.findViewById<EditText>(R.id.porcentajeConductor)
        val numeroPeajes = view.findViewById<EditText>(R.id.numeroPeajes)
        val valorPeaje = view.findViewById<EditText>(R.id.valorPeaje)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(view)
        addDialog.setPositiveButton("Guardar") { dialog, _ ->
            val nombreArchivo = nombreArchivo.text.toString()
            val planilla1 = planilla1.text.toString()
            val planilla2 = planilla2.text.toString()
            val planilla3 = planilla3.text.toString()
            val planilla4 = planilla4.text.toString()
            val gastoCombustible = gastoCombustible.text.toString()
            val muchileo = muchileo.text.toString()
            val gastosAdicionales = gastosAdicionales.text.toString()
            val porcentajeConductor = porcentajeConductor.text.toString()
            val numeroPeajes = numeroPeajes.text.toString()
            val valorPeaje = valorPeaje.text.toString()

            informeList.add(Informe(
                "Nombre Del Archivo: $nombreArchivo",
                "Planilla1: $planilla1",
                "Planilla2: $planilla2",
                "Planilla3: $planilla3",
                "Planilla4: $planilla4",
                "Gasto Combustible: $gastoCombustible",
                "Muchileo: $muchileo",
                "Gastos Adicionales: $gastosAdicionales",
                "Porcentaje Conductor: $porcentajeConductor",
                "Numero Peajes: $numeroPeajes",
                "Valor Peaje: $valorPeaje",
                "Fecha de Creación: ${getCurrentDate()}"))
            saveInformeListToSharedPreferences()
            informeAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }

    private fun loadInformeListFromSharedPreferences(): ArrayList<Informe> {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val informeSet = sharedPreferences.getStringSet("informeList", emptySet()) ?: emptySet()
        return informeSet.map { Informe.fromString(it) }.toCollection(ArrayList())
    }

    fun saveInformeListToSharedPreferences() {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putStringSet("informeList", informeList.map { it.toString() }.toSet())
        editor.apply()
    }
}
