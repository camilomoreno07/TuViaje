package com.example.tuviaje2.adapter

import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje2.R
import com.example.tuviaje2.model.Noticia
import java.io.InputStream
import java.net.URL

class NoticiaAdapter(
    private val noticias: List<Noticia>,
    private val onNoticiaClickListener: (String) -> Unit
) : RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>() {

    inner class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            // Asigna un click listener a la vista para manejar los clics
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val url = noticias[position].url
                    onNoticiaClickListener(url)
                }
            }
        }

        fun bind(noticia: Noticia) {
            // Configura la información de la noticia en las vistas
            tituloTextView.text = noticia.titulo
            descripcionTextView.text = noticia.descripcion

            // Cargar la imagen sin usar Glide (puedes ajustar según tus necesidades)
            // En este ejemplo, se asume que noticia.imageUrl es la URL de la imagen
            LoadImageTask(imageView).execute(noticia.imageUrl)
        }
    }

    private inner class LoadImageTask(private val imageView: ImageView) :
        AsyncTask<String, Void, Drawable?>() {

        override fun doInBackground(vararg params: String?): Drawable? {
            try {
                val inputStream = URL(params[0]).content as InputStream
                return Drawable.createFromStream(inputStream, "src")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Drawable?) {
            result?.let {
                imageView.setImageDrawable(it)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_noticia, parent, false)
        return NoticiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        // Configura la información de la noticia en el NoticiaViewHolder
        holder.bind(noticias[position])
    }

    override fun getItemCount(): Int {
        return noticias.size
    }
}

