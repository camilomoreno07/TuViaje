package com.example.tuviaje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje.Informe
import com.example.tuviaje.R

class InformeAdapter(private val informesList:List<Informe>) : RecyclerView.Adapter<InformeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InformeViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = informesList.size

    override fun onBindViewHolder(holder: InformeViewHolder, position: Int) {
        val item = informesList[position]
        holder.render(item)

    }

}