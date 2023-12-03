package com.example.tuviaje2.controller

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
import com.example.tuviaje2.view.InformeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InformeActivity : AppCompatActivity() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var informeList:ArrayList<Informe>
    private lateinit var informeAdapter: InformeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informe_activity)

        informeList = ArrayList()
        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        /**set Adapter*/
        informeAdapter =InformeAdapter(this,informeList)
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = informeAdapter
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }


    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.add_item, null)
        val userName = view.findViewById<EditText>(R.id.nombre)
        val userNo = view.findViewById<EditText>(R.id.loadTwo)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(view)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val name = userName.text.toString()
            val number = userNo.text.toString()
            informeList.add(Informe("Nombre: $name", "Fecha de Creación: ${getCurrentDate()}"))
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



    /**ok now run this */

}