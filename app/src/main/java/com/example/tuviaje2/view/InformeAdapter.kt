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

class InformeAdapter(val context: Context, val informeList: ArrayList<Informe>) :
    RecyclerView.Adapter<InformeAdapter.InformeViewHolder>() {

    inner class InformeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val costoGasolina: TextView = view.findViewById(R.id.mTitle)
        val porcentajeConductor: TextView = view.findViewById(R.id.mSubTitle)
        val menu: ImageView = view.findViewById(R.id.mMenus)

        init {
            menu.setOnClickListener { popupMenus() }
        }

        private fun popupMenus() {
            val position = informeList[bindingAdapterPosition]
            val popupMenus = PopupMenu(context, menu)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editText -> {
                        val view = LayoutInflater.from(context).inflate(R.layout.add_item, null)
                        val name = view.findViewById<EditText>(R.id.loadOne)
                        val number = view.findViewById<EditText>(R.id.loadTwo)
                        AlertDialog.Builder(context)
                            .setView(view)
                            .setPositiveButton("Ok") { dialog, _ ->
                                position.valorGasolina = name.text.toString()
                                position.porcentajeConductor = number.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(context, "Informe Editado", Toast.LENGTH_SHORT).show()
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
                        AlertDialog.Builder(context)
                            .setTitle("Borrar")
                            .setIcon(R.drawable.ic_warning)
                            .setMessage("Estás seguro que quieres borrar este registro?")
                            .setPositiveButton("Yes") { dialog, _ ->
                                informeList.removeAt(bindingAdapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(context, "Registro borrado", Toast.LENGTH_SHORT).show()
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

            try {
                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true
                val menu = popup.get(popupMenus)
                menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu, true)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return InformeViewHolder(view)
    }

    override fun onBindViewHolder(holder: InformeViewHolder, position: Int) {
        val item = informeList[position]
        holder.costoGasolina.text = item.valorGasolina
        holder.porcentajeConductor.text = item.porcentajeConductor
    }

    override fun getItemCount(): Int {
        return informeList.size
    }
}
