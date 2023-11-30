package com.example.tuviaje2.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje2.R
import com.example.tuviaje2.model.Informe

class InformeAdapter(val c:Context, val informeList:ArrayList<Informe>):RecyclerView.Adapter<InformeAdapter.InformeViewHolder>() {

    inner class InformeViewHolder(val v:View) : RecyclerView.ViewHolder(v){
        var costoGasolina:TextView
        var porcentajeConductor:TextView
        var menu: ImageView

        init{
            costoGasolina = v.findViewById<TextView>(R.id.mTitle)
            porcentajeConductor = v.findViewById<TextView>(R.id.mSubTitle)
            menu = v.findViewById(R.id.mMenus)
            menu.setOnClickListener{popupMenus(it)}
        }

        private fun popupMenus(v: View) {
            val position = informeList[bindingAdapterPosition]
            val popupMenus = PopupMenu(c, v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {
                        val v = LayoutInflater.from(c).inflate(R.layout.add_item, null)
                        val name = v.findViewById<EditText>(R.id.userName)
                        val number = v.findViewById<EditText>(R.id.userNo)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok") { dialog, _ ->
                                position.valorGasolina = name.text.toString()
                                position.porcentajeConductor = number.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(c, "Informe Editado", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("Cancelar") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true
                    }
                    R.id.delete -> {
                        // set delete
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.ic_warning)
                            .setMessage("Are you sure you want to delete this information?")
                            .setPositiveButton("Yes") { dialog, _ ->
                                informeList.removeAt(bindingAdapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c, "Deleted this Information", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true
                    }
                    else -> true
                }
            }
            popupMenus.show()

            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.item_list,parent,false)
        return InformeViewHolder(v)
    }

    override fun onBindViewHolder(holder: InformeViewHolder, position: Int) {
        val newList = informeList[position]
        holder.costoGasolina.text = newList.valorGasolina
        holder.porcentajeConductor.text = newList.porcentajeConductor
    }

    override fun getItemCount(): Int {
        return  informeList.size
    }
}