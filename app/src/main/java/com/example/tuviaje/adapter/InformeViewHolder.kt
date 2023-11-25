package com.example.tuviaje.adapter

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje.Informe
import com.example.tuviaje.R

class InformeViewHolder(view: View) : RecyclerView.ViewHolder(view){


    val galon = view.findViewById<TextView>(R.id.textView1)
    val valorGalon = view.findViewById<TextView>(R.id.textView1)

    fun render(informeModel: Informe){
        galon.text = informeModel.gastoGasolina
        valorGalon.text = informeModel.valorGasolina.toString()
    }

}